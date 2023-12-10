package com.miniprojet.location_des_voitures.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class TableauDeBordResponse {
    private Long nbrClients;
    private Long nbrLocations;
    private Double revenu;
    private Long nbrVoitures;
    private List<VoitureDisponibleResponse> voituresDisponible;
}
