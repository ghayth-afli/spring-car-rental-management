package com.miniprojet.location_des_voitures.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class ClientRequest {
    @NotNull(message = "Le Cin est requis")
    @Min(value = 10000000, message = "Le Cin doit être un nombre à 8 chiffres")
    @Max(value = 99999999, message = "Le Cin doit être un nombre à 8 chiffres")
    private Long Cin;
    @NotNull(message = "Le Permis de conduire est requis")
    private Long Permis_de_conduire;
    @NotBlank(message = "Le Nom est requis")
    private String Nom;
    @NotBlank(message = "Le Prénom est requis")
    private String Prenom;
    @NotBlank(message = "L'Adresse est requise")
    private String Adresse;
    @NotBlank(message = "L'Email est requis")
    @Email(message = "L'Email doit être valide")
    private String Email;
    @NotBlank(message = "Le Téléphone est requis")
    @Pattern(regexp="\\d{8}", message="Le Téléphone doit être un numéro à 8 chiffres")
    private String Telephone;
    @NotNull(message = "La Date de Naissance est requise")
    @Past(message = "La Date de Naissance doit être dans le passé")
    private Date Date_de_Naissance;
}
