package com.miniprojet.location_des_voitures.models;

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
    @NotBlank
    private String immatriculation;
    @NotBlank
    private String marque;
    @NotBlank
    private String modele;
    @NotBlank
    private Date dateDeMiseEnCirculation;
    @NotBlank
    private Double prixDeLocation;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private EStatut statutDeDisponibilite;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ECarburant typeDeCarburant;
    @NotBlank
    private Double kilometrage;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ETransmission typeDeTransmission;
    @NotBlank
    private String couleur;
    @NotBlank
    private Short nombreDeplaces;
    @NotBlank
    private String options;
    @NotBlank
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
