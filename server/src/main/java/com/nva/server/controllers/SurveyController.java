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
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/surveys")
@PropertySource("classpath:configs.properties")
@Slf4j
public class SurveyController {
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;
    @Autowired
    private HollandService hollandService;
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
                .build();
        Survey savedSurvey = surveyService.save(survey);

        return "redirect:/admin/surveys/" + savedSurvey.getId();
    }

    @GetMapping("/{surveyId}")
    public String showSurveyDetail(@PathVariable(name = "surveyId") Long surveyId, Model model) {
        Optional<Survey> surveyOptional = surveyService.findById(surveyId);
        if (surveyOptional.isPresent()) {
            model.addAttribute("survey", surveyOptional.get());

            List<Question> questions = questionService.findBySurveyId(surveyId);
            model.addAttribute("questions", questions);

            return "survey-detail";
        } else {
            return "error";
        }
    }

    @PostMapping("/{surveyId}")
    public String updateSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questions", questionService.findBySurveyId(survey.getId()));
            return "survey-detail";
        }

        survey.setUpdatedAt(new Date());
        surveyService.save(survey);
        return "redirect:/admin/surveys";
    }

    @GetMapping("/{surveyId}/delete")
    public String confirmDeleteSurvey(@PathVariable("surveyId") Long surveyId, Model model) {
        model.addAttribute("surveyId", surveyId);
        return "delete-survey-confirmation";
    }

    @PostMapping("/{surveyId}/delete")
    public String deleteSurvey(@PathVariable("surveyId") Long surveyId) {
        surveyService.deleteById(surveyId);
        return "redirect:/admin/surveys";
    }

    @GetMapping("/{surveyId}/add-questions")
    public String createQuestionForm(@PathVariable("surveyId") Long surveyId, Model model) {
        Optional<Survey> surveyOptional = surveyService.findById(surveyId);
        if (surveyOptional.isPresent()) {
            Question question = Question.builder().survey(surveyOptional.get()).build();
            model.addAttribute("question", question);

            model.addAttribute("hollandList", hollandService.findAll());

            return "survey-add-question";
        }
        return "error";
    }

    @PostMapping("/{surveyId}/add-questions")
    @Transactional
    public String addQuestions(@Valid @ModelAttribute("question") Question question, BindingResult bindingResult, Model model) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hollandList", hollandService.findAll());
            return "survey-add-question";
        }

        Question finalQuestion = Question.builder()
                .id(question.getId())
                .content(question.getContent())
                .survey(question.getSurvey())
                .createdAt(new Date())
                .holland(question.getHolland()).build();

        questionService.save(finalQuestion);

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> stringArrayOptions = objectMapper.readValue(question.getListOptions(), List.class);

        stringArrayOptions.forEach(q ->
                optionService.save(Option.builder()
                        .question(finalQuestion)
                        .createdAt(new Date())
                        .content(q).build()));

        return "redirect:/admin/surveys/" + question.getSurvey().getId() + "/add-questions";
    }
}
