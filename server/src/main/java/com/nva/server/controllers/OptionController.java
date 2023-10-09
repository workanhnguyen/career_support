package com.nva.server.controllers;

import com.nva.server.pojos.Option;
import com.nva.server.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("admin/options")
public class OptionController {
    @Autowired
    private OptionService optionService;
    @GetMapping("/{optionId}")
    public String detail(@PathVariable("optionId") Long optionId, Model model) {
        Optional<Option> optionalOption = optionService.findById(optionId);

        if (optionalOption.isPresent()) {
            model.addAttribute("option", optionalOption.get());
            return "option-detail";
        }

        return "error";
    }
}
