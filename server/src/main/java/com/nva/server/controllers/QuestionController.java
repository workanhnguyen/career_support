package com.nva.server.controllers;

import com.nva.server.pojos.Question;
import com.nva.server.pojos.Survey;
import com.nva.server.services.HollandService;
import com.nva.server.services.OptionService;
import com.nva.server.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/admin/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;
    @Autowired
    private HollandService hollandService;
    @GetMapping("/{questionId}")
    public String detail(@PathVariable("questionId") Long questionId, Model model) {
        Optional<Question> questionOptional = questionService.findById(questionId);

        if (questionOptional.isPresent()) {
            model.addAttribute("question", questionOptional.get());
            model.addAttribute("listOptions", optionService.findByQuestionId(questionId));
            model.addAttribute("listHollands", hollandService.findAll());

            return "question-detail";
        }
        return "error";
    }

    @PostMapping("/{questionId}")
    public String updateSurvey(@Valid @ModelAttribute("question") Question question, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listOptions", optionService.findByQuestionId(question.getId()));
            model.addAttribute("listHollands", hollandService.findAll());
            return "question-detail";
        }

        question.setUpdatedAt(new Date());
        questionService.save(question);
        return "redirect:/admin/surveys/" + question.getSurvey().getId();
    }
}
