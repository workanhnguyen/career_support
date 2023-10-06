package com.nva.server.services;

import com.nva.server.pojos.Survey;

import java.util.List;

public interface SurveyService {
    List<Survey> findAll();
}
