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
    @Column(name = "id")
    private Long Id;
    @NotBlank
    @Column(name = "immatriculation")
    private String Immatriculation;
    @NotBlank
    @Column(name = "marque")
    private String Marque;
    @NotBlank
    @Column(name = "modele")
    private String Modele;
    @NotBlank
    @Column(name = "date_de_mise_en_circulation")
    private Date Date_de_Mise_en_Circulation;
    @NotBlank
    @Column(name = "prix_de_location")
    private Double Prix_de_Location;
    @NotBlank
    @Column(name = "statut_de_disponibilite")
    @Enumerated(EnumType.STRING)
    private EStatut Statut_de_Disponibilite;
    @NotBlank
    @Column(name = "type_de_carburant")
    @Enumerated(EnumType.STRING)
    private ECarburant Type_de_Carburant;
    @NotBlank
    @Column(name = "kilometrage")
    private Double Kilometrage;
    @NotBlank
    @Column(name = "type_de_transmission")
    @Enumerated(EnumType.STRING)
    private ETransmission Type_de_Transmission;
    @NotBlank
    @Column(name = "couleur")
    private String Couleur;
    @NotBlank
    @Column(name = "nombre_de_places")
    private Short Nombre_de_Places;
    @NotBlank
    @Column(name = "options")
    private String Options;
    @NotBlank
    @Column(name = "image")
    private String Image;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

    public Voiture(String immatriculation, String marque, String modele, Date date_de_Mise_en_Circulation, Double prix_de_Location, EStatut statut_de_Disponibilite, ECarburant type_de_Carburant, Double kilometrage, ETransmission type_de_Transmission, String couleur, Short nombre_de_Places, String options, String image, Agent agent) {
        Immatriculation = immatriculation;
        Marque = marque;
        Modele = modele;
        Date_de_Mise_en_Circulation = date_de_Mise_en_Circulation;
        Prix_de_Location = prix_de_Location;
        Statut_de_Disponibilite = statut_de_Disponibilite;
        Type_de_Carburant = type_de_Carburant;
        Kilometrage = kilometrage;
        Type_de_Transmission = type_de_Transmission;
        Couleur = couleur;
        Nombre_de_Places = nombre_de_Places;
        Options = options;
        Image = image;
        this.agent = agent;
    }
}
