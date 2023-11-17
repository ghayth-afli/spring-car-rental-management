package com.miniprojet.location_des_voitures.repositories;

import com.miniprojet.location_des_voitures.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {
}