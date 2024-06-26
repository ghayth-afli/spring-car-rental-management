package com.miniprojet.location_des_voitures.repository;

import com.miniprojet.location_des_voitures.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {
    Optional<Agent> findByEmail(String username);
    Boolean existsByIdentifiant(String identifiant);
}