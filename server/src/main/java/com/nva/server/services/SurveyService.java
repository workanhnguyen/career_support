package com.nva.server.services;

import com.nva.server.pojos.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
    Optional<Survey> findById(Long surveyId);
    List<Survey> findAll();
    Page<Survey> findByKeyword(String keyword, Pageable pageable);
    Survey save(Survey survey);
//    Survey findByIdWithQuestions(Long surveyId);
}
