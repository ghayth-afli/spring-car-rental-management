package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.VoitureRequest;
import com.miniprojet.location_des_voitures.model.ECarburant;
import com.miniprojet.location_des_voitures.model.EStatut;
import com.miniprojet.location_des_voitures.model.ETransmission;
import com.miniprojet.location_des_voitures.model.Voiture;
import com.miniprojet.location_des_voitures.service.IVoitureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return "backOffice/voiture/index";
    }

    @GetMapping("/create")
    //display create voiture form
    public String createVoiture(Model model){
        model.addAttribute("voitureRequest", new VoitureRequest());
        return "backOffice/voiture/create";
    }

    @PostMapping("/create")
    //create voiture
    public String createVoiture(@Valid  @ModelAttribute("voitureRequest") VoitureRequest voitureRequest,
                                BindingResult bindingResult,final @RequestParam MultipartFile file)throws IOException{
        if (bindingResult.hasErrors()){
            return "backOffice/voiture/create";
        }
        //save image
        StringBuilder fileNames = new StringBuilder();
        String randomName = UUID.randomUUID().toString();
        Path fileNameAndPath = Paths.get("src/main/resources/static/images", randomName+file.getOriginalFilename());
        fileNames.append(randomName+file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        //save voiture
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
                fileNames.toString(),
                null,
                //generate reference
                "REF"+UUID.randomUUID().toString().substring(0, 8).toUpperCase()
        );
        voitureService.createVoiture(voiture);
        return "redirect:/voitures";
    }

    @GetMapping("/{id}/edit")
    //display edit voiture form
    public String editVoiture(Model model, @PathVariable Long id){
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            VoitureRequest voitureRequest = new VoitureRequest(
                    voiture.get().getId(),
                    voiture.get().getImmatriculation(),
                    voiture.get().getMarque(),
                    voiture.get().getModele(),
                    voiture.get().getDateDeMiseEnCirculation(),
                    voiture.get().getPrixDeLocation(),
                    voiture.get().getTypeDeCarburant(),
                    voiture.get().getKilometrage(),
                    voiture.get().getTypeDeTransmission(),
                    voiture.get().getCouleur(),
                    voiture.get().getNombreDeplaces(),
                    voiture.get().getOptions(),
                    voiture.get().getImage()
            );
            model.addAttribute("voitureRequest", voitureRequest);
            return "backOffice/voiture/edit";
        }
        return "redirect:/voitures";
    }

    @PostMapping("/{id}/edit")
    //edit voiture
    public String editVoiture(@PathVariable Long id, @Valid  @ModelAttribute("voitureRequest") VoitureRequest voitureRequest,
                              BindingResult bindingResult,final @RequestParam MultipartFile file){
        if (bindingResult.hasErrors()){
            return "backOffice/voiture/edit";
        }
        if (!file.isEmpty()){
            //save image
            StringBuilder fileNames = new StringBuilder();
            String randomName = UUID.randomUUID().toString();
            Path fileNameAndPath = Paths.get("src/main/resources/static", randomName+file.getOriginalFilename());
            fileNames.append(randomName+file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            voitureRequest.setImage(fileNames.toString());
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

    //for frontOffice
    @GetMapping("/all")
    //display all voitures
    public String getAllVoituresFront(Model model){
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("voitures", voitures);
        return "frontOffice/car-list";
    }
    //voitures/filter
    @GetMapping("/filter")
    //display all voitures
    public String filterVoituresFront(Model model, @RequestParam String voiture_marque, @RequestParam String vehicle_carburant, @RequestParam String vehicle_transmission){
        List<Voiture> voitures = voitureService.filterVoitures(voiture_marque,
                ECarburant.valueOf(vehicle_carburant),
                ETransmission.valueOf(vehicle_transmission));
        model.addAttribute("voitures", voitures);
        return "frontOffice/car-list";
    }
    @GetMapping("/{id}/details")
    public String getVoitureById(Model model, @PathVariable Long id){
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            model.addAttribute("voiture", voiture.get());
            return "frontOffice/car-details";
        }
        return "redirect:/voitures/all";
    }

    //En maintenance
    @PostMapping("/{id}/maintenance")
    public String maintenance(Model model, @PathVariable Long id){
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            voiture.get().setStatutDeDisponibilite(EStatut.En_maintenance);
            voitureService.updateVoiture(voiture.get());
        }
        return "redirect:/voitures";
    }

    //Disponible
    @PostMapping("/{id}/disponible")
    public String disponible(Model model, @PathVariable Long id){
        Optional<Voiture> voiture = voitureService.getVoitureById(id);
        if (voiture.isPresent()){
            voiture.get().setStatutDeDisponibilite(EStatut.Disponible);
            voitureService.updateVoiture(voiture.get());
        }
        return "redirect:/voitures";
    }
}