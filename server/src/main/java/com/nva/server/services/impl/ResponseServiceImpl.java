package com.nva.server.services.impl;

import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;
import com.nva.server.pojos.Holland;
import com.nva.server.pojos.Option;
import com.nva.server.pojos.Question;
import com.nva.server.services.HollandService;
import com.nva.server.services.OptionService;
import com.nva.server.services.QuestionService;
import com.nva.server.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    private HollandService hollandService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;
    @Override
    public List<ResultHollandResponseDTO> calculateAndSaveHollandResult(ResponseSurveyHollandFromClientDTO response) {
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
}
