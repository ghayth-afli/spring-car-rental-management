package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Location;

import java.util.List;
import java.util.Optional;

public interface ILocationService {
    List<Location> getAllLocations();
    Optional<Location> getLocationById(Long id);
    void createLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(Long id);
    List<Location> getLocationsByClient(Long id);
    List<Location> getLocationsByVoiture(Long id);
}
