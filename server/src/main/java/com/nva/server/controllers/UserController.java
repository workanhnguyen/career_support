package com.nva.server.controllers;

import com.nva.server.pojos.User;
import com.nva.server.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/admin/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String listUser(Model model) {
        model.addAttribute("users", userService.convertToAdminDTO(userService.findAll()));
        return "list-user";
    }

    @GetMapping("/{userId}")
    public String detail(@PathVariable("userId") Long userId, Model model) {
        Optional<User> userOptional = userService.findById(userId);

        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "user-detail";
        }
        return "error";
    }

    @PostMapping("/{userId}")
    @Transactional
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user-detail";

        user.setUpdatedAt(new Date());
        if (userService.updateUser(user))
            return "redirect:/admin/users";
        return "error";
    }

    @GetMapping("/{userId}/disable")
    public String confirmDisableUser(@PathVariable("userId") Long userId, Model model) {
        Optional<User> userOptional = userService.findById(userId);

        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "disable-user-confirmation";
        }

        return "error";
    }

    @PostMapping("/{userId}/disable")
    public String disableUser(@PathVariable("userId") Long userId) {
        Optional<User> userOptional = userService.findById(userId);

        if (userOptional.isPresent()) {
            User finalUser = userOptional.get();
            finalUser.setEnabled(false);

            userService.updateUser(finalUser);
            return "redirect:/admin/users/" + userId;
        }
        return "error";
    }

    @GetMapping("/{userId}/enable")
    public String confirmEnableUser(@PathVariable("userId") Long userId, Model model) {
        Optional<User> userOptional = userService.findById(userId);

        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "enable-user-confirmation";
        }

        return "error";
    }

    @PostMapping("/{userId}/enable")
    public String enableUser(@PathVariable("userId") Long userId) {
        Optional<User> userOptional = userService.findById(userId);

        if (userOptional.isPresent()) {
            User finalUser = userOptional.get();
            finalUser.setEnabled(true);

            userService.updateUser(finalUser);
            return "redirect:/admin/users/" + userId;
        }
        return "error";
    }
}
