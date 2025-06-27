package com.example.login.controller;

import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        boolean success = userService.authenticate(username, password);
        if (success) {
            model.addAttribute("username", username);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}
