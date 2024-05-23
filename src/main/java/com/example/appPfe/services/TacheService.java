package com.example.appPfe.services;

import com.example.appPfe.entites.*;
import com.example.appPfe.repository.StagiaireRepo;
import com.example.appPfe.repository.SuperviseurRepo;
import com.example.appPfe.repository.TacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TacheService {

    @Autowired
    private final TacheRepo tacheRepo;

    @Autowired
    private final StagiaireRepo stagiaireRepo;

    @Autowired
    private final SuperviseurRepo superviseurRepo;

    public TacheDTO createAndAssignTache(String nomTache, String descriptionTache, Date deadline, StatuTache status, String nomStagiaire, Long superviseurId) {
        Optional<Stagiaire> stagiaireOptional = stagiaireRepo.findByNomStagiaire(nomStagiaire);
        Optional<Superviseur> superviseurOptional = superviseurRepo.findById(superviseurId);

        if (!stagiaireOptional.isPresent()) {
            throw new IllegalArgumentException("Stagiaire with name " + nomStagiaire + " not found");
        }

        if (!superviseurOptional.isPresent()) {
            throw new IllegalArgumentException("Superviseur with ID " + superviseurId + " not found");
        }

        Stagiaire stagiaire = stagiaireOptional.get();
        Superviseur superviseur = superviseurOptional.get();

        Tache tache = Tache.builder()
                .nomTache(nomTache)
                .descriptionTache(descriptionTache)
                .deadline(deadline)
                .status(StatuTache.valueOf(String.valueOf(status)))
                .stagiaire(stagiaire)
                .superviseur(superviseur)
                .build();

        tacheRepo.save(tache);

        return new TacheDTO(
                tache.getNomTache(),
                tache.getDescriptionTache(),
                tache.getDeadline(),
                tache.getStatus().toString(),
                stagiaire.getNomStagiaire(),
                superviseur.getNomSuperviseur()
        );
    }

    public List<Tache> getAllTaches() {
        return tacheRepo.findAll();
    }

    public Tache getTache(Long id) {
        return tacheRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Tache with ID " + id + " not found"));
    }

    public void deleteTache(Long id) {
        Tache tache = getTache(id);
        tacheRepo.delete(tache);
    }

    public Tache updateTache(Long id, Tache tache) {
        Tache existingTache = getTache(id);
        existingTache.setNomTache(tache.getNomTache());
        existingTache.setDescriptionTache(tache.getDescriptionTache());
        existingTache.setDeadline(tache.getDeadline());
        existingTache.setStatus(tache.getStatus());
        existingTache.setStagiaire(tache.getStagiaire());
        existingTache.setSuperviseur(tache.getSuperviseur());

        return tacheRepo.save(existingTache);
    }


    public void updateTacheStatut(Long tacheId, StatuTache newStatut) {
        Tache tache = tacheRepo.findById(tacheId).orElse(null);
        if (tache != null) {
            tache.setStatus(newStatut);
            tacheRepo.save(tache);
        }
    }


}
