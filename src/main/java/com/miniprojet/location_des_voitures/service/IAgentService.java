package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Agent;

public interface IAgentService {
    Boolean existsByIdentifiant(String identifiant);
    public Integer createAgent(Agent agent);
}
