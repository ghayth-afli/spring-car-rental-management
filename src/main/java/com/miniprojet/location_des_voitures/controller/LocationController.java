package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.LocationRequest;
import com.miniprojet.location_des_voitures.model.ELocation;
import com.miniprojet.location_des_voitures.model.EStatut;
import com.miniprojet.location_des_voitures.model.Location;
import com.miniprojet.location_des_voitures.model.Voiture;
import com.miniprojet.location_des_voitures.service.IClientService;
import com.miniprojet.location_des_voitures.service.ILocationService;
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
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    ILocationService locationService;
    @Autowired
    IClientService clientService;
    @Autowired
    IVoitureService voitureService;

    @GetMapping("/client/{id}")
    //display all locations of a client
    public String getLocationsByClient(@PathVariable Long id, Model model){
        List<Location> locations = locationService.getLocationsByClient(id);
        model.addAttribute("id",id);
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
        model.addAttribute("id",id);
        model.addAttribute("locationRequest",new LocationRequest());
        return "backoffice/client/location-create";
    }

    @PostMapping("/client/{id}/create")
    //create a location
    public String createLocation(@PathVariable Long id, @Valid @ModelAttribute("locationRequest") LocationRequest locationRequest,
                                 BindingResult bindingResult,Model model){
        System.out.println(bindingResult.hasErrors());
        System.out.println(locationRequest.toString());
        Optional<Voiture> voiture = voitureService.getVoitureByReference(locationRequest.getReference());
        if (!voiture.isPresent()){
            bindingResult.rejectValue("reference","error.reference","reference not found");
        }
        if (voiture.get().getStatutDeDisponibilite().equals(EStatut.En_location)){
            bindingResult.rejectValue("reference","error.reference","voiture is already in location");
        }
        if (voiture.get().getStatutDeDisponibilite().equals(EStatut.En_maintenance)){
            bindingResult.rejectValue("reference","error.reference","voiture is in maintenance");
        }
        if (locationRequest.getDateDeDebut()!=null && locationRequest.getDateDeFin()!=null){
            if (locationRequest.getDateDeDebut().after(locationRequest.getDateDeFin())){
                bindingResult.rejectValue("dateDeDebut","error.dateDeDebut","la date de début doit être inférieur à la date de fin");
            }
        }
        if (bindingResult.hasErrors()){
            return "backoffice/client/location-create";
        }

        //calculate number of days
        long diff = locationRequest.getDateDeFin().getTime() - locationRequest.getDateDeDebut().getTime();
        int numberOfDays = (int) (diff / (1000*60*60*24));
        //calculate total price
        Double totalPrice = numberOfDays * voiture.get().getPrixDeLocation();
        Location location = new Location(
                locationRequest.getTypeDeGarantie(),
                totalPrice,
                locationRequest.getModeDePaiement(),
                locationRequest.getMontantDeGarantie(),
                ELocation.En_Cours,
                locationRequest.getDateDeDebut(),
                locationRequest.getDateDeFin(),
                voiture.get(),
                clientService.getClientById(id).get()
        );
        locationService.createLocation(location);
        voiture.get().setStatutDeDisponibilite(EStatut.En_location);
        voitureService.updateVoiture(voiture.get());
        return "redirect:/locations/client/"+id;
    }
    //display form to edit a location
    @GetMapping("/{id}/edit")
    //display form to edit a location
    public String editLocation(@PathVariable Long id, Model model){
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()){
            LocationRequest locationRequest = new LocationRequest(
                    location.get().getId(),
                    location.get().getVoiture().getReference(),
                    location.get().getTypeDeGarantie(),
                    location.get().getModeDePaiement(),
                    location.get().getMontantDeGarantie(),
                    location.get().getDateDeDebut(),
                    location.get().getDateDeFin()
            );
            model.addAttribute("locationRequest", locationRequest);
            return "backoffice/client/location-edit";
        }
        return "redirect:/locations/client/"+id;
    }
    //edit a location
    @PostMapping("/{id}/edit")
    //edit a location
    public String editLocation(@PathVariable Long id, @Valid @ModelAttribute("locationRequest") LocationRequest locationRequest,
                               Model model, BindingResult bindingResult){
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()){
            Optional<Voiture> voiture = voitureService.getVoitureByReference(locationRequest.getReference());
            if (!voiture.isPresent()){
                bindingResult.rejectValue("immatriculation","error.immatriculation","immatriculation not found");
            }
            if (locationRequest.getDateDeDebut()!=null && locationRequest.getDateDeFin()!=null){
                if (locationRequest.getDateDeDebut().after(locationRequest.getDateDeFin())){
                    bindingResult.rejectValue("dateDeDebut","error.dateDeDebut","la date de début doit être inférieur à la date de fin");
                }
            }
            if (bindingResult.hasErrors()){
                return "backoffice/client/location-edit";
            }
            location.get().setTypeDeGarantie(locationRequest.getTypeDeGarantie());
            location.get().setModeDePaiement(locationRequest.getModeDePaiement());
            location.get().setMontantDeGarantie(locationRequest.getMontantDeGarantie());
            location.get().setDateDeDebut(locationRequest.getDateDeDebut());
            location.get().setDateDeFin(locationRequest.getDateDeFin());
            locationService.updateLocation(location.get());
        }
        return "redirect:/clients";
    }
    //delete a location
    @PostMapping("/{id}/delete")
    //delete a location
    public String deleteLocation(@PathVariable Long id, Model model){
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()){
            locationService.deleteLocation(id);
        }
        return "redirect:/clients";
    }

    // end location
    @PostMapping("/{id}/end")
    //end location
    public String endLocation(@PathVariable Long id, Model model){
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()){
            location.get().setStatutDeLaLocation(ELocation.Terminée);
            locationService.updateLocation(location.get());
            location.get().getVoiture().setStatutDeDisponibilite(EStatut.Disponible);
            voitureService.updateVoiture(location.get().getVoiture());
        }
        return "redirect:/clients";
    }

}