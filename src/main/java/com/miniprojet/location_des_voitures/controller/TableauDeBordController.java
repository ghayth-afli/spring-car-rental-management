package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.responses.TableauDeBordResponse;
import com.miniprojet.location_des_voitures.model.EStatut;
import com.miniprojet.location_des_voitures.model.Voiture;
import com.miniprojet.location_des_voitures.service.IClientService;
import com.miniprojet.location_des_voitures.service.ILocationService;
import com.miniprojet.location_des_voitures.service.IVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

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
    public String getTableauDeBord(Model model){
        int nbrClients = clientService.getAllClients().size();
        int nbrLocations = locationService.getAllLocations().size();
        Double revenu = locationService.getAllLocations().stream().mapToDouble(location -> location.getFraisDeLocation()).sum();
        int nbrVoitures = voitureService.getAllVoitures().size();
        // les voitures avec le statut Disponible
        List<Voiture> voituresDisponible = voitureService.getAllVoitures().stream().filter(voiture -> voiture.getStatutDeDisponibilite().equals(EStatut.Disponible)).toList();
        TableauDeBordResponse tableauDeBordResponse = new TableauDeBordResponse(nbrClients, nbrLocations, revenu, nbrVoitures, voituresDisponible);
        model.addAttribute("tableauDeBord", tableauDeBordResponse);
        return "backoffice/tableauDeBord";
    }
}
