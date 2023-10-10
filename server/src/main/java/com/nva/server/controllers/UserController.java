package com.nva.server.controllers;

import com.nva.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String listUser(Model model) {
        model.addAttribute("users", userService.convertToAdminDTO(userService.findAll()));
        return "list-user";
    }
}
