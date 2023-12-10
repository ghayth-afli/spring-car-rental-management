package com.miniprojet.location_des_voitures.dto.responses;

import com.miniprojet.location_des_voitures.model.ECarburant;
import com.miniprojet.location_des_voitures.model.ETransmission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class VoitureDisponibleResponse {
    private Long id;
    private String immatriculation;
    private String marque;
    private String modele;
    private Date dateDeMiseEnCirculation;
    private Double prixDeLocation;
    private ECarburant typeDeCarburant;
    private Double kilometrage;
    private ETransmission typeDeTransmission;
    private String couleur;
    private Short nombreDeplaces;
}
