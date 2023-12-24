package com.miniprojet.location_des_voitures.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "voitures",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "immatriculation")
        })
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String immatriculation;
    private String marque;
    private String modele;
    private Date dateDeMiseEnCirculation;
    private Double prixDeLocation;
    @Enumerated(EnumType.STRING)
    private EStatut statutDeDisponibilite;
    @Enumerated(EnumType.STRING)
    private ECarburant typeDeCarburant;
    private Double kilometrage;
    @Enumerated(EnumType.STRING)
    private ETransmission typeDeTransmission;
    private String couleur;
    private Short nombreDeplaces;
    private String options;
    private String image;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

    public Voiture(String immatriculation, String marque, String modele, Date dateDeMiseEnCirculation, Double prixDeLocation, EStatut statutDeDisponibilite, ECarburant typeDeCarburant, Double kilometrage, ETransmission typeDeTransmission, String couleur, Short nombreDeplaces, String options, String image, Agent agent) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
        this.prixDeLocation = prixDeLocation;
        this.statutDeDisponibilite = statutDeDisponibilite;
        this.typeDeCarburant = typeDeCarburant;
        this.kilometrage = kilometrage;
        this.typeDeTransmission = typeDeTransmission;
        this.couleur = couleur;
        this.nombreDeplaces = nombreDeplaces;
        this.options = options;
        this.image = image;
        this.agent = agent;
    }
}
