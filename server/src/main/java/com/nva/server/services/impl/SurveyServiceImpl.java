package com.nva.server.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nva.server.dtos.SurveyDTO;
import com.nva.server.pojos.Survey;
import com.nva.server.repositories.SurveyRepository;
import com.nva.server.services.QuestionService;
import com.nva.server.services.SurveyService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j // Create Logger
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    @Transactional
    public Optional<Survey> findById(Long surveyId) {
        return surveyRepository.findById(surveyId);
    }

    @Override
    public <T> T convertToDTO(Survey survey, Class<T> dtoClass) {
        if (dtoClass.isAssignableFrom(SurveyDTO.class)) {
            return (T) modelMapper.map(survey, SurveyDTO.class);
        }

        return (T) survey;
    }

    @Override
    public <T> List<T> convertListToDTO(List<Survey> surveys, Class<T> dtoClass) {
        return surveys.stream().map(survey -> modelMapper.map(survey, dtoClass)).collect(Collectors.toList());
    }

    @Override
    public SurveyDTO findSurveyByIdFullQuestions(Long surveyId) {
        Optional<Survey> surveyOptional = surveyRepository.findById(surveyId);

        if (surveyOptional.isPresent()) {
            SurveyDTO surveyDTO = modelMapper.map(surveyOptional.get(), SurveyDTO.class);
            surveyDTO.setQuestions(questionService.findBySurveyId(surveyId).stream().map(
                    question -> questionService.findQuestionByIdFullOptions(question.getId())
            ).collect(Collectors.toSet()));
            return surveyDTO;
        }

        return null;
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll(Sort.by(Sort.Order.desc("createdAt")));
    }

    @Override
    public Page<Survey> findByKeyword(String keyword, Pageable pageable) {
        return surveyRepository.findByKeyword(keyword, pageable);
    }

    @Override
    public Survey save(Survey survey) {
        if (survey.getImageFile() != null && !survey.getImageFile().isEmpty()) {
            try {
                Map response = this.cloudinary.uploader().upload(survey.getImageFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                survey.setImage(response.get("secure_url").toString());

                return surveyRepository.save(survey);
            } catch (IOException e) {
                log.error(e.getMessage());
                return new Survey();
            }
        }
        return surveyRepository.save(survey);
    }

    @Override
    public void deleteById(Long surveyId) {
        surveyRepository.deleteById(surveyId);
    }

//    @Override
//    public Survey findByIdWithQuestions(Long surveyId) {
//        return surveyRepository.findByIdWithQuestions(surveyId);
//    }
}
