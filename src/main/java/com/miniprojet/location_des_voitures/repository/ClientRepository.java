package com.miniprojet.location_des_voitures.repository;

import com.miniprojet.location_des_voitures.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByCin(Long Cin);
}