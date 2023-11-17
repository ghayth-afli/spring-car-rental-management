package com.miniprojet.location_des_voitures.dtos.requests;

import com.miniprojet.location_des_voitures.models.ECarburant;
import com.miniprojet.location_des_voitures.models.EStatut;
import com.miniprojet.location_des_voitures.models.ETransmission;
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
    private Long Immatriculation;
    @NotBlank(message = "La marque est requise")
    private String Marque;
    @NotBlank(message = "Le modèle est requis")
    private String Modele;
    @NotNull(message = "La date de mise en circulation est requise")
    private Date Date_de_Mise_en_Circulation;
    @NotNull(message = "Le prix de location est requis")
    @Min(value = 0, message = "Le prix de location doit être supérieur ou égal à 0")
    private Double Prix_de_Location;
    @NotNull(message = "Le statut de disponibilité est requis")
    private EStatut Statut_de_Disponibilite;
    @NotNull(message = "Le type de carburant est requis")
    private ECarburant Type_de_Carburant;
    @NotNull(message = "Le kilométrage est requis")
    @Min(value = 0, message = "Le kilométrage doit être supérieur ou égal à 0")
    private Double Kilometrage;
    @NotNull(message = "Le type de transmission est requis")
    private ETransmission Type_de_Transmission;
    @NotBlank(message = "La couleur est requise")
    private String Couleur;
    @NotNull(message = "Le nombre de places est requis")
    @Min(value = 1, message = "Le nombre de places doit être d'au moins 1")
    private Short Nombre_de_Places;
}
