package com.example.appPfe.repository;

import com.example.appPfe.entites.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepo extends JpaRepository<Rapport,Long> {


    Rapport getRapportByTitre(String titre);
}
