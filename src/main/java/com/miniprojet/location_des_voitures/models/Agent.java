package com.miniprojet.location_des_voitures.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "agent",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "identifiant"),
                @UniqueConstraint(columnNames = "email")
        })
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "nom")
    private String Nom;
    @Column(name = "prenom")
    private String Prenom;
    @NotBlank
    @Column(name = "identifiant")
    private String Identifiant;
    @NotBlank
    @Column(name = "password")
    private String Mot_de_Passe;
    @NotBlank
    @Email
    @Column(name = "email")
    private String Email;
    @Column(name = "telephone")
    private String Telephone;
    @OneToMany(mappedBy = "agent")
    private List<Voiture> voitures;

    public Agent(String nom, String prenom, String identifiant, String mot_de_Passe, String email, String telephone) {
        Nom = nom;
        Prenom = prenom;
        Identifiant = identifiant;
        Mot_de_Passe = mot_de_Passe;
        Email = email;
        Telephone = telephone;
    }
}
