package com.miniprojet.location_des_voitures.model;

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
    private String identifiant;
    private String password;
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
