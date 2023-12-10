package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    void createClient(Client client);
    void updateClient(Client client);
    void deleteClient(Long id);
}
