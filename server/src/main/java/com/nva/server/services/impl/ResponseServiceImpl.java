package com.nva.server.services.impl;

import com.nva.server.dtos.QuestionResponseDTO;
import com.nva.server.dtos.ResponseForClientDTO;
import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;
import com.nva.server.pojos.*;
import com.nva.server.repositories.ResponseDetailRepository;
import com.nva.server.repositories.ResponseRepository;
import com.nva.server.services.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private HollandService hollandService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;
    @Autowired
    private UserService userService;
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private ResponseDetailService responseDetailService;
    @Autowired
    private ResponseDetailRepository responseDetailRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(ResponseSurveyHollandFromClientDTO response) {
        // Save the response
        Response savedResponse = Response.builder()
                .user(userService.findById(response.getUserId()).get())
                .survey(surveyService.findById(response.getSurveyId()).get())
                .createdAt(new Date()).build();
        savedResponse = responseRepository.save(savedResponse);

        // Save the response details
        Response finalSavedResponse = savedResponse;
        Set<QuestionResponseDTO> questionResponseDTOs = response.getQuestions();

        for (QuestionResponseDTO questionResponseDTO : questionResponseDTOs) {
            Set<Integer> optionIds = questionResponseDTO.getOptions();

            for (Integer optionId : optionIds) {
                ResponseDetail responseDetail = ResponseDetail.builder()
                        .response(finalSavedResponse)
                        .question(questionService.findById(questionResponseDTO.getId()).get())
                        .selectedOption(optionService.findById(Long.parseLong(String.valueOf(optionId))).get())
                        .build();
                responseDetailService.save(responseDetail);
            }
        }
    }

    @Override
    public List<ResultHollandResponseDTO> calculateHollandResult(ResponseSurveyHollandFromClientDTO response) {
        List<ResultHollandResponseDTO> resultHollands = new ArrayList<>();

        response.getQuestions().forEach(question -> {
            ResultHollandResponseDTO result = new ResultHollandResponseDTO();
            Optional<Question> questionOptional = questionService.findById(question.getId());
            result.setHolland(hollandService.findById(questionOptional.get().getHolland().getId()).get());

            List<Option> options = optionService.findByQuestionId(question.getId());

            int selectedOptionsCount = question.getOptions().size();
            int totalOptionsCount = options.size();

            if (totalOptionsCount > 0) {
                double percentage = ((double) selectedOptionsCount / totalOptionsCount) * 100.0;
                result.setPercentage(percentage);
            } else {
                result.setPercentage(0.0); // Avoid division by zero
            }

            resultHollands.add(result);
        });

        return resultHollands;
    }

    @Override
    public List<ResultHollandResponseDTO> getHollandResultDetails(Long responseId) {
        Optional<Response> responseOptional = responseRepository.findById(responseId);

        if (responseOptional.isPresent()) {
            ResponseSurveyHollandFromClientDTO responseSurveyHollandFromClientDTO = new ResponseSurveyHollandFromClientDTO();
            responseSurveyHollandFromClientDTO.setUserId(responseOptional.get().getUser().getId());
            responseSurveyHollandFromClientDTO.setSurveyId(responseOptional.get().getSurvey().getId());

            List<ResponseDetail> responseDetails = responseDetailRepository.findByResponseId(responseOptional.get().getId());
            Set<Map<String, Object>> questions = new HashSet<>();
            responseDetails.forEach(responseDetail -> {
                questions.add(Map.of("questionId", responseDetail.getQuestion().getId(), "optionId", responseDetail.getSelectedOption().getId()));
            });

            Map<Long, QuestionResponseDTO> resultMap = new HashMap<>();
            for (Map<String, Object> entry: questions) {
                Long questionId = (Long) entry.get("questionId");
                Long optionId = (Long) entry.get("optionId");

                QuestionResponseDTO questionResponseDTO = resultMap.get(questionId);
                if (questionResponseDTO == null) {
                    questionResponseDTO = QuestionResponseDTO.builder()
                            .id(questionId)
                            .options(new HashSet<>()).build();

                    resultMap.put(questionId, questionResponseDTO);
                }
                questionResponseDTO.getOptions().add(Integer.parseInt(String.valueOf(optionId)));
            }
            Set<QuestionResponseDTO> formattedResult = new HashSet<>(resultMap.values());
            responseSurveyHollandFromClientDTO.setQuestions(formattedResult);

            return calculateHollandResult(responseSurveyHollandFromClientDTO);
        }

        return null;
    }

    @Override
    @Transactional
    public List<ResultHollandResponseDTO> calculateAndSaveHollandResult(ResponseSurveyHollandFromClientDTO response) {
        save(response);
        return calculateHollandResult(response);
    }

    @Override
    public List<ResponseForClientDTO> findByUserId(Long userId) {
        List<Response> responses = responseRepository.findByUserId(userId);
        List<ResponseForClientDTO> responseForClientDTOs = new ArrayList<>();

        responses.forEach(response -> {
            ResponseForClientDTO responseForClientDTO = modelMapper.map(response, ResponseForClientDTO.class);
            responseForClientDTO.setSurveyTitle(response.getSurvey().getTitle());
            responseForClientDTOs.add(responseForClientDTO);
        });

        return responseForClientDTOs;
    }

    @Override
    public Optional<Response> findById(Long responseId) {
        return responseRepository.findById(responseId);
    }
}
