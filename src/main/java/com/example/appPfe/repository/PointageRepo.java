package com.example.appPfe.repository;

import com.example.appPfe.entites.Pointage;
import com.example.appPfe.entites.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointageRepo extends JpaRepository<Pointage,Long> {

}
