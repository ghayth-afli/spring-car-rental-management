package com.miniprojet.location_des_voitures.dto.responses;

import com.miniprojet.location_des_voitures.model.Voiture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class TableauDeBordResponse {
    private int nbrClients;
    private int nbrLocations;
    private Double revenu;
    private int nbrVoitures;
    private List<Voiture> voituresDisponible;
}
