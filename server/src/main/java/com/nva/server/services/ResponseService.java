package com.nva.server.services;

import com.nva.server.dtos.ResponseForClientDTO;
import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;
import com.nva.server.pojos.Response;

import java.util.List;
import java.util.Optional;

public interface ResponseService {
    void save(ResponseSurveyHollandFromClientDTO response);
    List<ResultHollandResponseDTO> calculateHollandResult(ResponseSurveyHollandFromClientDTO response);
    List<ResultHollandResponseDTO> getHollandResultDetails(Long responseId);
    List<ResultHollandResponseDTO> calculateAndSaveHollandResult(ResponseSurveyHollandFromClientDTO response);
    List<ResponseForClientDTO> findByUserId(Long userId);
    Optional<Response> findById(Long responseId);
}
