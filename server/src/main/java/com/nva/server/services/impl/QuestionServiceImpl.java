package com.nva.server.services.impl;

import com.nva.server.dtos.QuestionDTO;
import com.nva.server.pojos.Question;
import com.nva.server.repositories.QuestionRepository;
import com.nva.server.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
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
    public List<QuestionDTO> convertToDTO(List<Question> questions) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();

        questions.forEach(q -> questionDTOs.add(modelMapper.map(q, QuestionDTO.class)));

        return questionDTOs;
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
