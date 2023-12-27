package com.miniprojet.location_des_voitures.service;

import com.miniprojet.location_des_voitures.model.Voiture;
import com.miniprojet.location_des_voitures.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureServiceImpl implements IVoitureService{
    @Autowired
    VoitureRepository voitureRepository;
    @Override
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    @Override
    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    @Override
    public void createVoiture(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    @Override
    public void updateVoiture(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    @Override
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

    @Override
    public Optional<Voiture> getVoitureByReference(String immatriculation) {
        return voitureRepository.findVoitureByReference(immatriculation);
    }
}
