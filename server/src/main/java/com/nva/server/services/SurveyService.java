package com.nva.server.services;

import com.nva.server.pojos.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
    Optional<Survey> findById(Long surveyId);
    <T> T convertToDTO(Survey survey, Class<T> dtoClass);
    <T> List<T> convertListToDTO(List<Survey> surveys, Class<T> dtoClass);
    List<Survey> findAll();
    Page<Survey> findByKeyword(String keyword, Pageable pageable);
    Survey save(Survey survey);
    void deleteById(Long surveyId);
}
