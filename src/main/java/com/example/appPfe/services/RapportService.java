package com.example.appPfe.services;

import com.example.appPfe.entites.Rapport;
import com.example.appPfe.repository.RapportRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RapportService {


    @Autowired
    private final RapportRepo rapportRepo;

    public List<Rapport> getAllRapport() {
        return rapportRepo.findAll();
    }
    public Rapport getRapportById(Long id) {
        return rapportRepo.getById(id);
    }

    public Rapport GetRapportByTitre(String titre) {
        return rapportRepo.getRapportByTitre(titre);
    }
    public Rapport CreateRapport(Rapport rapport) {
        return rapportRepo.save(rapport);
    }
    public void deleteRapport(Long id) {
        Rapport rapport = getRapportById(id);
        rapportRepo.delete(rapport);
    }

    public Rapport updateRapport(Long id, Rapport rapportDetails) {
        Rapport rapport = getRapportById(id);

        rapport.setTitre(rapportDetails.getTitre());
        rapport.setFile(rapportDetails.getFile());

        return rapportRepo.save(rapport);
    }
}
