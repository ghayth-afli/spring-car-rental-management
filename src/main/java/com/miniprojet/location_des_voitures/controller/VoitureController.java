package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.VoitureRequest;
import com.miniprojet.location_des_voitures.model.EStatut;
import com.miniprojet.location_des_voitures.model.Voiture;
import com.miniprojet.location_des_voitures.service.IVoitureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/voitures")
public class VoitureController {
    @Autowired
    IVoitureService voitureService;

    @GetMapping
    //display all voitures
    public String getAllVoitures(Model model){
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("voitures", voitures);
        return "backoffice/voiture/index";
    }

    @GetMapping("/create")
    //display create voiture form
    public String createVoiture(Model model){
        return "backoffice/voiture/create";
    }

    @PostMapping("/create")
    //create voiture
    public String createVoiture(Model model, @Valid  @RequestBody VoitureRequest voitureRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "backoffice/voiture/create";
        }
        Voiture voiture = new Voiture(
                voitureRequest.getImmatriculation(),
                voitureRequest.getMarque(),
                voitureRequest.getModele(),
                voitureRequest.getDateDeMiseEnCirculation(),
                voitureRequest.getPrixDeLocation(),
                EStatut.Disponible,
                voitureRequest.getTypeDeCarburant(),
                voitureRequest.getKilometrage(),
                voitureRequest.getTypeDeTransmission(),
                voitureRequest.getCouleur(),
                voitureRequest.getNombreDePlaces(),
                voitureRequest.getOptions(),
                voitureRequest.getImage(),
                null
        );
        voitureService.createVoiture(voiture);
        return "redirect:/voitures";
    }

    @GetMapping("/{id}/edit")
    //display edit voiture form
    public String editVoiture(Model model, @PathVariable Long id){
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            model.addAttribute("voiture", voiture.get());
            return "backoffice/voiture/edit";
        }
        return "redirect:/voitures";
    }

    @PostMapping("/{id}/edit")
    //edit voiture
    public String editVoiture(Model model, @PathVariable Long id, @Valid @RequestBody VoitureRequest voitureRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "backoffice/voiture/edit";
        }
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            voiture.get().setImmatriculation(voitureRequest.getImmatriculation());
            voiture.get().setMarque(voitureRequest.getMarque());
            voiture.get().setModele(voitureRequest.getModele());
            voiture.get().setDateDeMiseEnCirculation(voitureRequest.getDateDeMiseEnCirculation());
            voiture.get().setPrixDeLocation(voitureRequest.getPrixDeLocation());
            voiture.get().setTypeDeCarburant(voitureRequest.getTypeDeCarburant());
            voiture.get().setKilometrage(voitureRequest.getKilometrage());
            voiture.get().setTypeDeTransmission(voitureRequest.getTypeDeTransmission());
            voiture.get().setCouleur(voitureRequest.getCouleur());
            voiture.get().setNombreDeplaces(voitureRequest.getNombreDePlaces());
            voiture.get().setOptions(voitureRequest.getOptions());
            voiture.get().setImage(voitureRequest.getImage());
            voitureService.updateVoiture(voiture.get());
        }
        return "redirect:/voitures";
    }

    @PostMapping("/{id}/delete")
    //delete voiture
    public String deleteVoiture(Model model, @PathVariable Long id){
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            voitureService.deleteVoiture(id);
        }
        return "redirect:/voitures";
    }
}