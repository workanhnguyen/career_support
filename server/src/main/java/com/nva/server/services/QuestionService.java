package com.nva.server.services;

import com.nva.server.dtos.QuestionDTO;
import com.nva.server.pojos.Question;
import com.nva.server.pojos.Survey;

import java.util.List;

public interface QuestionService {
    void save(Question question);
    List<QuestionDTO> findBySurveyId(Long surveyId);
}
