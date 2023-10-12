package com.nva.server.services;

import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;

import java.util.List;

public interface ResponseService {
    List<ResultHollandResponseDTO> calculateAndSaveHollandResult(ResponseSurveyHollandFromClientDTO response);
}
