package com.miniprojet.location_des_voitures.models;

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
                @UniqueConstraint(columnNames = "permis_de_conduire"),
                @UniqueConstraint(columnNames = "cin"),
                @UniqueConstraint(columnNames = "email")
        })
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @NotBlank
    @Column(name = "cin")
    private Long Cin;
    @NotBlank
    @Column(name = "permis_de_conduire")
    private Long Permis_de_conduire;
    @NotBlank
    @Column(name = "nom")
    private String Nom;
    @NotBlank
    @Column(name = "prenom")
    private String Prenom;
    @NotBlank
    @Column(name = "adresse")
    private String Adresse;
    @NotBlank
    @Email
    @Column(name = "email")
    private String Email;
    @NotBlank
    @Column(name = "telephone")
    private String Telephone;
    @NotBlank
    @Column(name = "date_de_naissance")
    private Date Date_de_Naissance;
    @NotBlank
    @Column(name = "date_enregistrement")
    private Date Date_Enregistrement;
    @OneToMany(mappedBy = "client")
    private List<Location> locations;

    public Client(Long cin, Long permis_de_conduire, String nom, String prenom, String adresse, String email, String telephone, Date date_de_Naissance, Date date_Enregistrement) {
        Cin = cin;
        Permis_de_conduire = permis_de_conduire;
        Nom = nom;
        Prenom = prenom;
        Adresse = adresse;
        Email = email;
        Telephone = telephone;
        Date_de_Naissance = date_de_Naissance;
        Date_Enregistrement = date_Enregistrement;
    }
}
