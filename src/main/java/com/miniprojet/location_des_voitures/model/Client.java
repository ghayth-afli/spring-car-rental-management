package com.miniprojet.location_des_voitures.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "clients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "permisDeConduire"),
                @UniqueConstraint(columnNames = "cin"),
                @UniqueConstraint(columnNames = "email")
        })
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Long cin;
    @NotBlank
    private Long permisDeConduire;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    private String adresse;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telephone;
    @NotBlank
    private Date dateDeNaissance;
    @NotBlank
    private Date dateEnregistrement;
    @OneToMany(mappedBy = "client")
    private List<Location> locations;

    public Client(Long cin, Long permis_de_conduire, String nom, String prenom, String adresse, String email, String telephone, Date date_de_Naissance, Date date_enregistrement) {
        this.cin = cin;
        this.permisDeConduire = permis_de_conduire;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.dateDeNaissance = date_de_Naissance;
        this.dateEnregistrement = date_enregistrement;
    }
}