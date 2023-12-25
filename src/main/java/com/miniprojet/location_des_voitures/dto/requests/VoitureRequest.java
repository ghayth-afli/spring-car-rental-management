package com.miniprojet.location_des_voitures.dto.requests;

import com.miniprojet.location_des_voitures.model.ECarburant;
import com.miniprojet.location_des_voitures.model.EStatut;
import com.miniprojet.location_des_voitures.model.ETransmission;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class VoitureRequest {
    @NotNull(message = "L'immatriculation est requise")
    private String immatriculation;
    @NotBlank(message = "La marque est requise")
    private String marque;
    @NotBlank(message = "Le modèle est requis")
    private String modele;
    //@NotNull(message = "La date de mise en circulation est requise")
    private Date dateDeMiseEnCirculation;
    @NotNull(message = "Le prix de location est requis")
    @Min(value = 0, message = "Le prix de location doit être supérieur ou égal à 0")
    private Double prixDeLocation;
    @NotNull(message = "Le type de carburant est requis")
    private ECarburant typeDeCarburant;
    @NotNull(message = "Le kilométrage est requis")
    @Min(value = 0, message = "Le kilométrage doit être supérieur ou égal à 0")
    private Double Kilometrage;
    @NotNull(message = "Le type de transmission est requis")
    private ETransmission typeDeTransmission;
    @NotBlank(message = "La couleur est requise")
    private String couleur;
    @NotNull(message = "Le nombre de places est requis")
    @Min(value = 1, message = "Le nombre de places doit être d'au moins 1")
    private Short nombreDePlaces;
    @NotBlank(message = "Les options sont requises")
    private String options;
    private String image;

    public VoitureRequest() {
    }
}
