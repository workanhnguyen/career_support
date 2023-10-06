package com.nva.server.services;

import com.nva.server.pojos.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SurveyService {
    List<Survey> findAll();
    Page<Survey> findByKeyword(String keyword, Pageable pageable);
}
