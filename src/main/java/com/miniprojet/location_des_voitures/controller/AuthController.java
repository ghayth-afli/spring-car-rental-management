package com.miniprojet.location_des_voitures.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // L'utilisateur est déjà connecté, rediriger vers une autre page
            return "redirect:/access-denied";
        }
        // Sinon, afficher la page de connexion
        return "backOffice/login";
    }
}
