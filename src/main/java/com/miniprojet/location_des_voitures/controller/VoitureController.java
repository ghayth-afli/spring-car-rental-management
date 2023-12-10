package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.VoitureRequest;
import com.miniprojet.location_des_voitures.service.IVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voitures")
public class VoitureController {
    @Autowired
    IVoitureService voitureService;

    @GetMapping
    //display all voitures
    public String getAllVoitures(Model model){
        return null;
    }

    @GetMapping("/create")
    //display create voiture form
    public String createVoiture(Model model){
        return null;
    }

    @PostMapping("/create")
    //create voiture
    public String createVoiture(Model model, @RequestBody VoitureRequest voitureRequest){
        return null;
    }

    @GetMapping("/{id}/edit")
    //display edit voiture form
    public String editVoiture(Model model, @PathVariable Long id){
        return null;
    }

    @PostMapping("/{id}/edit")
    //edit voiture
    public String editVoiture(Model model, @PathVariable Long id, @RequestBody VoitureRequest voitureRequest){
        return null;
    }

    @PostMapping("/{id}/delete")
    //delete voiture
    public String deleteVoiture(Model model, @PathVariable Long id){
        return null;
    }
}
