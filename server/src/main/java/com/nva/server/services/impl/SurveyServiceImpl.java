package com.nva.server.services.impl;

import com.nva.server.pojos.Survey;
import com.nva.server.repositories.SurveyRepository;
import com.nva.server.services.SurveyService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j // Create Logger
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Optional<Survey> findById(Long surveyId) {
        return surveyRepository.findById(surveyId);
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public Page<Survey> findByKeyword(String keyword, Pageable pageable) {
        return surveyRepository.findByKeyword(keyword, pageable);
    }

    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }
}
