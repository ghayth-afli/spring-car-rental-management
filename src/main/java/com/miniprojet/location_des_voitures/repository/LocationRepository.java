package com.miniprojet.location_des_voitures.repository;

import com.miniprojet.location_des_voitures.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository  extends JpaRepository<Location,Long> {
    List<Location> findAllByClientId(Long id);
    List<Location> findAllByVoitureId(Long id);
}