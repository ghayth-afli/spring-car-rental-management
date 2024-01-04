package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Agent;
import com.miniprojet.location_des_voitures.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements IAgentService{
    @Autowired
    AgentRepository agentRepository;

    @Override
    public Boolean existsByIdentifiant(String identifiant) {
        return agentRepository.existsByIdentifiant(identifiant);
    }

    @Override
    public void createAgent(Agent agent) {
        agentRepository.save(agent);
    }
}
