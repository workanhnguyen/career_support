package com.nva.server.controllers;

import com.nva.server.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/surveys")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;
    @GetMapping
    public String listSurvey(Model model) {
        model.addAttribute("surveys", surveyService.findAll());
        return "list-survey";
    }

    @PostMapping
    public String addSurvey() {
        return "redirect:/list-survey";
    }
}
