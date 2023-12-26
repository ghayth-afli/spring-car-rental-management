package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Location;
import com.miniprojet.location_des_voitures.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationServiceImpl implements ILocationService{
    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public void createLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById((long) id);
    }

    @Override
    public List<Location> getLocationsByClient(Long id) {
        return locationRepository.findAllByClientId(id);
    }

    @Override
    public List<Location> getLocationsByVoiture(Long id) {
        return locationRepository.findAllByVoitureId(id);
    }
}
