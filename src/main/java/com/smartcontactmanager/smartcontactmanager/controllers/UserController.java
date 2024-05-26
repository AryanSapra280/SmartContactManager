package com.smartcontactmanager.smartcontactmanager.controllers;

import com.smartcontactmanager.smartcontactmanager.helperMessages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/do_register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult  bindingResult, Model model) {

        try {
            if(bindingResult.hasErrors()) {
                throw new Exception("please fill input correctly");
            }
            user.setRole("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            model.addAttribute("user",user);
            model.addAttribute("message",new Message("Successful registration","alert-success"));

        }catch (Exception e) {
            model.addAttribute("user",user);
            model.addAttribute("message",new Message("Something went wrong, "  + e.getMessage() + "!!","alert-danger"));

        }
        return "signup";

    }
}
