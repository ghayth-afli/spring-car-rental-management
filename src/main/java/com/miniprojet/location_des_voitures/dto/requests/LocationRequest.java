package com.miniprojet.location_des_voitures.dto.requests;

import com.miniprojet.location_des_voitures.model.EGarantie;
import com.miniprojet.location_des_voitures.model.ELocation;
import com.miniprojet.location_des_voitures.model.EPaiement;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class LocationRequest {
    @NotNull(message = "Le type de garantie est requis")
    private EGarantie typeDeGarantie;
    @NotNull(message = "Les frais de location sont requis")
    @Min(value = 0, message = "Les frais de location doivent être supérieurs ou égaux à 0")
    private Double fraisDeLocation;
    @NotNull(message = "Le mode de paiement est requis")
    private EPaiement modeDePaiement;
    @NotNull(message = "Le montant de garantie est requis")
    @Min(value = 0, message = "Le montant de garantie doit être supérieur ou égal à 0")
    private Double montantDeGarantie;
    @NotNull(message = "Le statut de la location est requis")
    private ELocation statutDeLaLocation;
    @NotNull(message = "La date de début est requise")
    @FutureOrPresent(message = "La date de début doit être dans le présent ou dans le futur")
    private Date dateDeDebut;
    @NotNull(message = "La date de fin est requise")
    @Future(message = "La date de fin doit être dans le futur")
    private Date dateDeFin;
    @NotBlank(message = "L'immatriculation est requise")
    private String immatriculation;
}