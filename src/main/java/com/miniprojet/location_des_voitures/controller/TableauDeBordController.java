package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.service.IClientService;
import com.miniprojet.location_des_voitures.service.ILocationService;
import com.miniprojet.location_des_voitures.service.IVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/tableau-de-bord")
public class TableauDeBordController {
    @Autowired
    ILocationService locationService;
    @Autowired
    IClientService clientService;
    @Autowired
    IVoitureService voitureService;

    @GetMapping
    public String getTableauDeBord(){
        return "tableau-de-bord";
    }
}
