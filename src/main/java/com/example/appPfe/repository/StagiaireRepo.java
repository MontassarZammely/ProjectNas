package com.example.appPfe.repository;

import com.example.appPfe.entites.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StagiaireRepo extends JpaRepository<Stagiaire,Long> {


    @Override
    List<Stagiaire> findAll();


    Optional<Stagiaire> findByNomStagiaire(String nomStagiaire);



}
