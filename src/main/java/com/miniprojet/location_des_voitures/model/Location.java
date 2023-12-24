package com.miniprojet.location_des_voitures.model;

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
    @Enumerated(EnumType.STRING)
    private EGarantie typeDeGarantie;
    private Double fraisDeLocation;
    @Enumerated(EnumType.STRING)
    private EPaiement modeDePaiement;
    private Double montantDeGarantie;
    @Enumerated(EnumType.STRING)
    private ELocation statutDeLaLocation;
    private Date dateDeDebut;
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
