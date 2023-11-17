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
    @Column(name = "id")
    private Long Id;
    @NotBlank
    @Column(name = "type_de_garantie")
    @Enumerated(EnumType.STRING)
    private EGarantie Type_de_Garantie;
    @NotBlank
    @Column(name = "frais_de_location")
    private Double Frais_de_Location;
    @NotBlank
    @Column(name = "mode_de_paiement")
    @Enumerated(EnumType.STRING)
    private EPaiement Mode_de_Paiement;
    @NotBlank
    @Column(name = "montant_de_garantie")
    private Double Montant_de_Garantie;
    @NotBlank
    @Column(name = "statut_de_la_location")
    @Enumerated(EnumType.STRING)
    private ELocation Statut_de_la_Location;
    @NotBlank
    @Column(name = "date_de_debut")
    private Date Date_de_Debut;
    @NotBlank
    @Column(name = "date_de_fin")
    private Date Date_de_Fin;
    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Location(EGarantie type_de_Garantie, Double frais_de_Location, EPaiement mode_de_Paiement, Double montant_de_Garantie, ELocation statut_de_la_Location, Date date_de_Debut, Date date_de_Fin, Voiture voiture, Client client) {
        Type_de_Garantie = type_de_Garantie;
        Frais_de_Location = frais_de_Location;
        Mode_de_Paiement = mode_de_Paiement;
        Montant_de_Garantie = montant_de_Garantie;
        Statut_de_la_Location = statut_de_la_Location;
        Date_de_Debut = date_de_Debut;
        Date_de_Fin = date_de_Fin;
        this.voiture = voiture;
        this.client = client;
    }
}
