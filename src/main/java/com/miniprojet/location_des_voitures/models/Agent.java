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
    private Integer id;
    private String nom;
    private String prenom;
    @NotBlank
    private String identifiant;
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
    private String telephone;
    @OneToMany(mappedBy = "agent")
    private List<Voiture> voitures;

    public Agent(String nom, String prenom, String identifiant, String mot_de_Passe, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.password = mot_de_Passe;
        this.email = email;
        this.telephone = telephone;
    }
}
