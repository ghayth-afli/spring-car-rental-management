package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Client;
import com.miniprojet.location_des_voitures.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements IClientService{
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
