package com.nva.server.controllers;

import com.nva.server.pojos.Option;
import com.nva.server.services.OptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping("/{optionId}")
    @Transactional
    public String update(@Valid @ModelAttribute("option") Option option, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "option-detail";

        Option finalOption = Option.builder()
                .id(option.getId())
                .content(option.getContent())
                .question(option.getQuestion())
                .createdAt(option.getCreatedAt())
                .updatedAt(new Date()).build();

        optionService.save(finalOption);

        return "redirect:/admin/questions/" + option.getQuestion().getId();
    }

    @GetMapping("/{optionId}/delete")
    public String confirmDeleteOption(@PathVariable("optionId") Long optionId, Model model) {
        Optional<Option> optionalOption = optionService.findById(optionId);

        if (optionalOption.isPresent()) {
            model.addAttribute("option", optionalOption.get());
            return "delete-option-confirmation";
        }
        return "error";
    }

    @PostMapping("/{optionId}/delete")
    public String deleteOption(@ModelAttribute("option") Option option) {
        optionService.deleteById(option.getId());
        return "redirect:/admin/questions/" + option.getQuestion().getId();
    }
}
