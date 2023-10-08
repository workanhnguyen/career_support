package com.nva.server.apis;

import com.nva.server.pojos.Survey;
import com.nva.server.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/surveys")
public class ApiSurveyController {
    @Autowired
    private SurveyService surveyService;
    @GetMapping
    public ResponseEntity<List<Survey>> getSurveys() {
        return new ResponseEntity<>(surveyService.findAll(), HttpStatus.OK);
    }
}
