package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Agent;
import com.miniprojet.location_des_voitures.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AgentServiceImpl implements IAgentService, UserDetailsService {
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public Boolean existsByIdentifiant(String identifiant) {
        return agentRepository.existsByIdentifiant(identifiant);
    }

    @Override
    public Integer createAgent(Agent agent) {
        String passwd= agent.getPassword();
        String encodedPasswod = passwordEncoder.encode(passwd);
        agent.setPassword(encodedPasswod);
        agent = agentRepository.save(agent);
        return agent.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Agent> opt = agentRepository.findByEmail(email);

        org.springframework.security.core.userdetails.User springUser=null;

        if(opt.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " +email +" not found");
        }
        Agent user =opt.get();
        List<String> roles = new ArrayList<>();
        roles.add("AGENT");
        Set<GrantedAuthority> ga = new HashSet<>();
        for(String role:roles) {
            ga.add(new SimpleGrantedAuthority(role));
        }

        springUser = new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                ga );
        return springUser;
    }
}
