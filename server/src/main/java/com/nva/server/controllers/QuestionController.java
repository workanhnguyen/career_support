package com.nva.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nva.server.pojos.Option;
import com.nva.server.pojos.Question;
import com.nva.server.pojos.Survey;
import com.nva.server.services.HollandService;
import com.nva.server.services.OptionService;
import com.nva.server.services.QuestionService;
import com.nva.server.services.SurveyService;
import com.nva.server.utils.PersistenceUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/questions")
@Slf4j
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;
    @Autowired
    private HollandService hollandService;
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private PersistenceUtil persistenceUtil;
    @GetMapping("/{questionId}")
    public String detail(@PathVariable("questionId") Long questionId, Model model) {
        Optional<Question> questionOptional = questionService.findById(questionId);

        if (questionOptional.isPresent()) {
            model.addAttribute("question", questionOptional.get());
            model.addAttribute("options", optionService.findByQuestionId(questionId));
            model.addAttribute("hollands", hollandService.findAll());

            return "question-detail";
        }
        return "error";
    }

    @PostMapping("/{questionId}")
    @Transactional
    public String updateSurvey(@Valid @ModelAttribute("question") Question question, BindingResult bindingResult, Model model) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("options", optionService.findByQuestionId(question.getId()));
            model.addAttribute("hollands", hollandService.findAll());
            return "question-detail";
        }

        Question finalQuestion = Question.builder()
                .id(question.getId())
                .content(question.getContent())
                .survey(question.getSurvey())
                .createdAt(question.getCreatedAt())
                .updatedAt(new Date())
                .holland(question.getHolland())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> stringArrayOptions = objectMapper.readValue(question.getListOptions(), List.class);

        Question managedQuestion = persistenceUtil.mergeEntity(finalQuestion);
        questionService.save(finalQuestion);

        stringArrayOptions.forEach(o ->
                optionService.save(Option.builder()
                        .question(managedQuestion)
                        .createdAt(new Date())
                        .content(o).build()));

        return "redirect:/admin/surveys/" + question.getSurvey().getId();
    }

    @GetMapping("/{questionId}/delete")
    public String confirmDeleteQuestion(@PathVariable("questionId") Long questionId, Model model) {
        Optional<Question> optionalQuestion = questionService.findById(questionId);

        if (optionalQuestion.isPresent()) {
//            log.warn(optionalQuestion.get().getSurvey().toString());
            model.addAttribute("question", optionalQuestion.get());
//            model.addAttribute("surveyId", optionalQuestion.get().getSurvey().getId());
            return "delete-question-confirmation";
        }
        return "error";
    }

    @PostMapping("/{questionId}/delete")
    public String deleteQuestion(@ModelAttribute("question") Question question) {
        questionService.deleteById(question.getId());
        return "redirect:/admin/surveys/" + question.getSurvey().getId();
    }
}
