package com.example.appPfe.services;

import com.example.appPfe.dtos.SuperviseurDTO;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.entites.Superviseur;
import com.example.appPfe.repository.StagiaireRepo;
import com.example.appPfe.repository.SuperviseurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuperviseurService {

    @Autowired
    private final SuperviseurRepo superviseurRepo;


    public List<Superviseur> getAllSuperviseurs() {
        return superviseurRepo.findAll();
    }
    public Superviseur getSuperviseur(Long id) {
        return superviseurRepo.getById(id);
    }

    public Superviseur CreateSuperviseur(Superviseur superviseur) {
        return superviseurRepo.save(superviseur);
    }
    public void DeleteSuperviseur(Long id) {
        Superviseur superviseur = getSuperviseur(id);
        superviseurRepo.delete(superviseur);
    }

    public Superviseur updateSuperviseur(Long id, Superviseur superviseurDetails) {
        Superviseur superviseur = getSuperviseur(id);


        superviseur.setNomSuperviseur(superviseurDetails.getNomSuperviseur());
        superviseur.setPrenomSuperviseur(superviseurDetails.getPrenomSuperviseur());
        superviseur.setAdresseSuperviseur(superviseurDetails.getAdresseSuperviseur());
        superviseur.setTelephoneSuperviseur(superviseurDetails.getTelephoneSuperviseur());
        superviseur.setEmailSuperviseur(superviseurDetails.getEmailSuperviseur());
        superviseur.setMdpSuperviseur(superviseurDetails.getMdpSuperviseur());
        superviseur.setRole(superviseurDetails.getRole());

        return superviseurRepo.save(superviseur);

    }

    public List<SuperviseurDTO> getAllSuperviseursDTO() {
        return superviseurRepo.findAll().stream()
                .map(superviseur -> new SuperviseurDTO(
                        superviseur.getIdSuperviseur(),
                        superviseur.getNomSuperviseur(),
                        superviseur.getTelephoneSuperviseur(),
                        superviseur.getEmailSuperviseur()))
                .collect(Collectors.toList());
    }



}
