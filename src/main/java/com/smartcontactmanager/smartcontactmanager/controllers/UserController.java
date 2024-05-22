package com.smartcontactmanager.smartcontactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smartcontactmanager.smartcontactmanager.entities.User;
import com.smartcontactmanager.smartcontactmanager.services.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/do_register")
    public String register(@ModelAttribute("user") User user, Model model) {
        user.setRole("ROLE_USER");
        userService.saveUser(user);
        return "signup";
    }
}
