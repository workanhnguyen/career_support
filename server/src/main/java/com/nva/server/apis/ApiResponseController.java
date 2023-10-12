package com.nva.server.apis;

import com.nva.server.dtos.ResponseSurveyHollandFromClientDTO;
import com.nva.server.dtos.ResultHollandResponseDTO;
import com.nva.server.services.HollandService;
import com.nva.server.services.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/responses")
@Slf4j
public class ApiResponseController {
    @Autowired
    private HollandService hollandService;
    @Autowired
    private ResponseService responseService;
    @PostMapping("/holland")
    public ResponseEntity<List<ResultHollandResponseDTO>> calculateHollandResult(@RequestBody ResponseSurveyHollandFromClientDTO response) {
        return new ResponseEntity<>(responseService.calculateAndSaveHollandResult(response), HttpStatus.OK);
    }
}
