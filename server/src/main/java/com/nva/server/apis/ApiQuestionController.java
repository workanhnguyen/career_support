package com.nva.server.apis;

import com.nva.server.dtos.OptionForClientDTO;
import com.nva.server.pojos.Question;
import com.nva.server.services.OptionService;
import com.nva.server.services.QuestionService;
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
@RequestMapping("/api/v1/questions")
public class ApiQuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;
    @GetMapping("/{questionId}/options")
    public ResponseEntity<List<OptionForClientDTO>> getOptionsByQuestionId(@PathVariable("questionId") Long questionId) {
        Optional<Question> questionOptional = questionService.findById(questionId);

        if (questionOptional.isPresent()) {
            return new ResponseEntity<>(optionService.convertToDTO(
                    optionService.findByQuestionId(questionOptional.get().getId()),
                    OptionForClientDTO.class), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
