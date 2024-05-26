package com.smartcontactmanager.smartcontactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smartcontactmanager.smartcontactmanager.entities.User;
import com.smartcontactmanager.smartcontactmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/do_register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult  bindingResult, Model model) {
        
        if(bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "signup";
        }
        user.setRole("ROLE_USER");
        userService.saveUser(user);
        return "signup"; 
    }
}
