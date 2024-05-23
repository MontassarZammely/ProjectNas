package com.example.appPfe.services;


import com.example.appPfe.entites.autorisation;
import com.example.appPfe.entites.statuAut;
import com.example.appPfe.repository.autorisationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class autorisationService {

    @Autowired
    private final autorisationRepo autorisationRepo;

    public List<autorisation> getAll() {
        return autorisationRepo.findAll();
    }
    public autorisation addAutorisation(autorisation autorisation) {
        return autorisationRepo.save(autorisation);
    }
    public autorisation getAutorisationById(Long id) {
        return autorisationRepo.findById(id).get();
    }

    // TODO update nombre restant d'autorisation
}
