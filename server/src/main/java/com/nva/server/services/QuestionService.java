package com.nva.server.services;

import com.nva.server.dtos.QuestionDTO;
import com.nva.server.dtos.QuestionForClientDTO;
import com.nva.server.pojos.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    void save(Question question);
    List<Question> findBySurveyId(Long surveyId);
    <T> List<T> convertToDTO(List<Question> questions, Class<T> dtoClass);
    Optional<Question> findById(Long questionId);
    void deleteById(Long questionId);
}
