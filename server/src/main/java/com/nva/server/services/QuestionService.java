package com.nva.server.services;

import com.nva.server.dtos.QuestionDTO;
import com.nva.server.pojos.Question;
import com.nva.server.pojos.Survey;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    void save(Question question);
    List<Question> findBySurveyId(Long surveyId);
    List<QuestionDTO> convertToDTO(List<Question> questions);
    Optional<Question> findById(Long questionId);
}
