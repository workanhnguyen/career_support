package com.nva.server.controllers;

import com.nva.server.pojos.Question;
import com.nva.server.pojos.Survey;
import com.nva.server.services.QuestionService;
import com.nva.server.services.SurveyService;
import com.nva.server.utils.DateFormat;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/surveys")
@PropertySource("classpath:configs.properties")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private Environment env;
    @GetMapping
    public String listSurvey(Model model) {
        Pageable pageable = PageRequest.of(0, Integer.parseInt(env.getProperty("PAGE_SIZE")));
        model.addAttribute("surveys", surveyService.findByKeyword("", pageable).getContent());
        return "list-survey";
    }

    @GetMapping("/add-new")
    public String createSurveyForm(Model model) {
        model.addAttribute("survey", new Survey());

        return "add-survey";
    }

    @PostMapping("/add-new")
    public String createSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add-survey";

        survey = Survey.builder()
                .title(survey.getTitle().trim())
                .description(survey.getDescription().trim())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        Survey savedSurvey = surveyService.save(survey);

        return "redirect:/surveys/" + savedSurvey.getId();
    }

    @GetMapping("/{surveyId}")
    public String showSurveyDetail(@PathVariable(name = "surveyId") Long surveyId, Model model) {
        Optional<Survey> surveyOptional = surveyService.findById(surveyId);
        if (surveyOptional.isPresent()) {
            Survey survey = surveyOptional.get();
            model.addAttribute("survey", survey);
            model.addAttribute("questions", new ArrayList<Question>());

            return "survey-detail";
        } else {
            return "error";
        }
    }

    @PostMapping("/{surveyId}")
    public String updateSurvey(@ModelAttribute("survey") Survey survey) {
        survey.setUpdatedAt(new Date());
        surveyService.save(survey);
        return "redirect:/surveys";
    }
}
