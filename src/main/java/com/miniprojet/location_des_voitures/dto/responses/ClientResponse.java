package com.miniprojet.location_des_voitures.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class ClientResponse {
    private Long id;
    private Long Cin;
    private Long Permis_de_conduire;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Email;
    private String Telephone;
    private Date Date_de_Naissance;
    private Date Date_enregistrement;
}
