package com.miniprojet.location_des_voitures.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(Model model){
        return "backoffice/login";
    }
}
