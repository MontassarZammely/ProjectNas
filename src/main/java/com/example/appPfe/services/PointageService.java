package com.example.appPfe.services;


import com.example.appPfe.entites.Pointage;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.repository.PointageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointageService {

    @Autowired
    private final PointageRepo pointageRepo;

    public List<Pointage> getAllPointages() {
        return pointageRepo.findAll();
    }
    public Pointage createPointage(Pointage pointage) {
        return pointageRepo.save(pointage);
    }
    public Pointage getpointageById(Long id) {
        return pointageRepo.findById(id).get();
    }






    public void enregistrerPointageEntre(Long stagiaireId) {
        Pointage pointage = new Pointage();
        pointage.setStagiaire(new Stagiaire(stagiaireId)); // Vous devrez peut-être récupérer le stagiaire de la base de données
        pointage.setPointageEntre(LocalDateTime.now());
        pointageRepo.save(pointage);
    }

}
