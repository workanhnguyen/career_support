package com.nva.server.controllers;

import com.nva.server.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/surveys")
@PropertySource("classpath:configs.properties")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private Environment env;
    @GetMapping
    public String listSurvey(Model model) {
        Pageable pageable = PageRequest.of(0, Integer.parseInt(env.getProperty("PAGE_SIZE")));
        model.addAttribute("surveys", surveyService.findByKeyword("", pageable).getContent());
        return "list-survey";
    }

    @PostMapping
    public String addSurvey() {
        return "redirect:/list-survey";
    }
}
