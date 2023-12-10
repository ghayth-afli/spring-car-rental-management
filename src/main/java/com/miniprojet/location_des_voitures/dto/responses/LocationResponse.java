package com.miniprojet.location_des_voitures.dto.responses;

import com.miniprojet.location_des_voitures.model.EGarantie;
import com.miniprojet.location_des_voitures.model.EPaiement;
import com.miniprojet.location_des_voitures.model.EStatut;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class LocationResponse {
    private Long id;
    private String voiture;
    private Date dateDebut;
    private Date dateFin;
    private EPaiement modeDePaiement;
    private Double fraisDeLocation;
    private EGarantie typeDeGarantie;
    private Double montantDeGarantie;
    private EStatut status;
    private Date dateEnregistrement;
}
