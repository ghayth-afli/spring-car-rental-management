package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.LocationRequest;
import com.miniprojet.location_des_voitures.model.Location;
import com.miniprojet.location_des_voitures.model.Voiture;
import com.miniprojet.location_des_voitures.service.IClientService;
import com.miniprojet.location_des_voitures.service.ILocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<Location> locations = locationService.getLocationsByClient(id);
        model.addAttribute("locations",locations);
        return "backoffice/client/location";
    }

    @GetMapping("/voiture/{id}")
    //display all locations of a voiture
    public String getLocationsByVoiture(@PathVariable Long id, Model model){
        List<Location> locations = locationService.getLocationsByVoiture(id);
        model.addAttribute("locations",locations);
        return "backoffice/voiture/location";
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

    @GetMapping("/client/{id}/edit/{id_location}")
    //display form to edit a location
    public String editLocation(@PathVariable Long id, Long id_location, Model model){
        return null;
    }

    @PostMapping("/client/{id}/edit/{id_location}")
    //edit a location
    public String editLocation(@PathVariable Long id, Long id_location, @Valid @RequestBody LocationRequest locationRequest, Model model, BindingResult bindingResult){
        return null;
    }

    @PostMapping("/{id}/delete")
    //delete a location
    public String deleteLocation(@PathVariable Long id, Model model){
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()){
            locationService.deleteLocation(id);
        }
        return "redirect:/clients";
    }
}