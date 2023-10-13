package com.nva.server.apis;

import com.nva.server.dtos.QuestionForClientDTO;
import com.nva.server.dtos.SurveyDTO;
import com.nva.server.pojos.Survey;
import com.nva.server.services.QuestionService;
import com.nva.server.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/surveys")
public class ApiSurveyController {
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;
    @GetMapping
    public ResponseEntity<List<SurveyDTO>> getSurveys() {
        return new ResponseEntity<>(surveyService.convertListToDTO(surveyService.findAll(), SurveyDTO.class), HttpStatus.OK);
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity<SurveyDTO> getSurveyById(@PathVariable("surveyId") Long surveyId) {
//        Optional<Survey> surveyOptional = surveyService.findById(surveyId);
        SurveyDTO surveyDTO = surveyService.findSurveyByIdFullQuestions(surveyId);
        if (surveyDTO != null) {
            return new ResponseEntity<>(surveyDTO, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{surveyId}/questions")
    public ResponseEntity<List<QuestionForClientDTO>> getQuestionsBySurveyId(@PathVariable("surveyId") Long surveyId) {
        Optional<Survey> surveyOptional = surveyService.findById(surveyId);

        if (surveyOptional.isPresent()) {
            return new ResponseEntity<>(questionService.convertToDTO(
                    questionService.findBySurveyId(surveyOptional.get().getId()),
                    QuestionForClientDTO.class), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
