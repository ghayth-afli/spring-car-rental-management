package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.LocationRequest;
import com.miniprojet.location_des_voitures.service.IClientService;
import com.miniprojet.location_des_voitures.service.ILocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    ILocationService locationService;
    @Autowired
    IClientService clientService;
    @Autowired
    ILocationService voitureService;

    @GetMapping("/client/{id}")
    //display all locations of a client
    public String getLocationsByClient(@PathVariable Long id, Model model){
        return null;
    }

    @GetMapping("/voiture/{id}")
    //display all locations of a voiture
    public String getLocationsByVoiture(@PathVariable Long id, Model model){
        return null;
    }

    @GetMapping("/client/{id}/create")
    //display form to create a location
    public String createLocation(@PathVariable Long id, Model model){
        return null;
    }

    @PostMapping("/client/{id}/create")
    //create a location
    public String createLocation(@PathVariable Long id, @Valid @RequestBody LocationRequest locationRequest, Model model, BindingResult bindingResult){
        return null;
    }

    @GetMapping("/client/{id}/edit/{id}")
    //display form to edit a location
    public String editLocation(@PathVariable Long id, Model model){
        return null;
    }

    @PostMapping("/client/{id}/edit/{id}")
    //edit a location
    public String editLocation(@PathVariable Long id, @Valid @RequestBody LocationRequest locationRequest, Model model, BindingResult bindingResult){
        return null;
    }

    @PostMapping("/client/{id}/delete/{id}")
    //delete a location
    public String deleteLocation(@PathVariable Long id, Model model){
        return null;
    }
}
