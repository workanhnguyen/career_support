package com.nva.server.services.impl;

import com.nva.server.dtos.OptionForClientDTO;
import com.nva.server.dtos.QuestionForClientDTO;
import com.nva.server.pojos.Question;
import com.nva.server.repositories.QuestionRepository;
import com.nva.server.services.OptionService;
import com.nva.server.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private OptionService optionService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public List<Question> findBySurveyId(Long surveyId) {
        return questionRepository.findBySurveyId(surveyId);
    }

    @Override
    public <T> List<T> convertToDTO(List<Question> questions, Class<T> dtoClass) {
        if (dtoClass.isAssignableFrom(QuestionForClientDTO.class)) {
            return questions.stream().map(question -> modelMapper.map(question, dtoClass)).toList();
        }
        return (List<T>) questions;
    }

    @Override
    public QuestionForClientDTO findQuestionByIdFullOptions(Long questionId) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);

        if (questionOptional.isPresent()) {
            QuestionForClientDTO questionDTO = modelMapper.map(questionOptional.get(), QuestionForClientDTO.class);
            questionDTO.setOptions(optionService.findByQuestionId(questionId).stream().map(
                    option -> modelMapper.map(option, OptionForClientDTO.class)
            ).collect(Collectors.toSet()));

            return questionDTO;
        }

        return null;
    }

    @Override
    public Optional<Question> findById(Long questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public void deleteById(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
