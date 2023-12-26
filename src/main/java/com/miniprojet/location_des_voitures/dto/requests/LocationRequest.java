package com.miniprojet.location_des_voitures.dto.requests;

import com.miniprojet.location_des_voitures.model.EGarantie;
import com.miniprojet.location_des_voitures.model.ELocation;
import com.miniprojet.location_des_voitures.model.EPaiement;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LocationRequest {
    @NotBlank(message = "L'immatriculation est requise")
    private String immatriculation;
    @NotNull(message = "Le type de garantie est requis")
    private EGarantie typeDeGarantie;
    @NotNull(message = "Le mode de paiement est requis")
    private EPaiement modeDePaiement;
    @NotNull(message = "Le montant de garantie est requis")
    @Min(value = 0, message = "Le montant de garantie doit être supérieur ou égal à 0")
    private Double montantDeGarantie;
    @NotNull(message = "La date de début est requise")
    @FutureOrPresent(message = "La date de début doit être dans le présent ou dans le futur")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeDebut;
    @NotNull(message = "La date de fin est requise")
    @Future(message = "La date de fin doit être dans le futur")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //date de fin doit être supérieur à la date de début
    private Date dateDeFin;
}
