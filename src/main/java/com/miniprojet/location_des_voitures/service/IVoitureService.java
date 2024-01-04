package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Client;
import com.miniprojet.location_des_voitures.model.ECarburant;
import com.miniprojet.location_des_voitures.model.ETransmission;
import com.miniprojet.location_des_voitures.model.Voiture;

import java.util.List;
import java.util.Optional;

public interface IVoitureService {
    List<Voiture> getAllVoitures();
    Optional<Voiture> getVoitureById(Long id);
    void createVoiture(Voiture voiture);
    void updateVoiture(Voiture voiture);
    void deleteVoiture(Long id);
    Optional<Voiture> getVoitureByReference(String reference);
    List<Voiture> filterVoitures(String voiture_marque, ECarburant vehicle_carburant, ETransmission vehicle_transmission);
}
