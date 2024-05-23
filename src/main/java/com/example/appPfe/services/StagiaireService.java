package com.example.appPfe.services;


import com.example.appPfe.dtos.StagiaireDTO;
import com.example.appPfe.dtos.SuperviseurDTO;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.repository.StagiaireRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StagiaireService {

    @Autowired
    private final StagiaireRepo stagiaireRepo;


    public List<Stagiaire> getAllStagiaires() {
        return stagiaireRepo.findAll();
    }


    public Stagiaire createStagiaire(Stagiaire stagiaire) {
        return stagiaireRepo.save(stagiaire);

    }

    public void deleteStagiaire(Long id) {
        Stagiaire stagiaire = getStagiaire(id);
        stagiaireRepo.delete(stagiaire);
    }

    public Stagiaire getStagiaire(Long id) {
        return stagiaireRepo.getById(id);
    }

    public Stagiaire updateStagiaire(Long id, Stagiaire stagiaireDetails) {
        Stagiaire stagiaire = getStagiaire(id);


        stagiaire.setNomStagiaire(stagiaireDetails.getNomStagiaire());
        stagiaire.setPrenomStagiaire(stagiaireDetails.getPrenomStagiaire());
        stagiaire.setAdresseStagiaire(stagiaireDetails.getAdresseStagiaire());
        stagiaire.setEmailStagiaire(stagiaireDetails.getEmailStagiaire());
        stagiaire.setDateD_Stage(stagiaireDetails.getDateD_Stage());
        stagiaire.setDateF_Stage(stagiaireDetails.getDateF_Stage());
        stagiaire.setMdpStagiaire(stagiaireDetails.getMdpStagiaire());
        stagiaire.setRole(stagiaireDetails.getRole());
        stagiaire.setTelephoneStagiaire(stagiaireDetails.getTelephoneStagiaire());

        return stagiaireRepo.save(stagiaire);

    }

    public List<StagiaireDTO> getAllStagiaireDTO() {
        return stagiaireRepo.findAll().stream()
                .map(stagiaire -> new StagiaireDTO(
                        stagiaire.getIdStagiaire(),
                        stagiaire.getNomStagiaire(),
                        stagiaire.getEmailStagiaire(),
                        stagiaire.getTelephoneStagiaire()))
                .collect(Collectors.toList());
    }



}
