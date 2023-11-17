package com.miniprojet.location_des_voitures.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private EGarantie typeDeGarantie;
    @NotBlank
    private Double fraisDeLocation;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private EPaiement modeDePaiement;
    @NotBlank
    private Double montantDeGarantie;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ELocation statutDeLaLocation;
    @NotBlank
    private Date dateDeDebut;
    @NotBlank
    private Date dateDeFin;
    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Location(EGarantie typeDeGarantie, Double fraisDeLocation, EPaiement modeDePaiement, Double montantDeGarantie, ELocation statutDeLaLocation, Date dateDeDebut, Date dateDeFin, Voiture voiture, Client client) {
        this.typeDeGarantie = typeDeGarantie;
        this.fraisDeLocation = fraisDeLocation;
        this.modeDePaiement = modeDePaiement;
        this.montantDeGarantie = montantDeGarantie;
        this.statutDeLaLocation = statutDeLaLocation;
        this.dateDeDebut = dateDeDebut;
        this.dateDeFin = dateDeFin;
        this.voiture = voiture;
        this.client = client;
    }
}
