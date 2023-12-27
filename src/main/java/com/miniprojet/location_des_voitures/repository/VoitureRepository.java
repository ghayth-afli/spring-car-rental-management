package com.miniprojet.location_des_voitures.repository;

import com.miniprojet.location_des_voitures.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    Optional<Voiture> findVoitureByReference(String Immatriculation);
}