package com.nva.server.services;

import com.nva.server.dtos.ResponseForClientDTO;
import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;
import com.nva.server.pojos.Response;

import java.util.List;

public interface ResponseService {
    List<ResultHollandResponseDTO> calculateAndSaveHollandResult(ResponseSurveyHollandFromClientDTO response);
    List<ResponseForClientDTO> findByUserId(Long userId);
}
