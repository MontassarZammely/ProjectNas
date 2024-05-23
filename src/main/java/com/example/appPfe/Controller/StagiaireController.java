package com.example.appPfe.Controller;

import com.example.appPfe.dtos.StagiaireDTO;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.services.StagiaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stagiaire")
@CrossOrigin("*")
public class StagiaireController {

    @Autowired
    private final StagiaireService stagiaireservice;


    @GetMapping("/getall")
    public List<Stagiaire> getAllStagiaires() {
        return stagiaireservice.getAllStagiaires();
    }
    @GetMapping("/get")
    public List<StagiaireDTO> getAllStagiaireDTO(){
        return stagiaireservice.getAllStagiaireDTO();
    }

    @PostMapping("/add")
    public ResponseEntity<Stagiaire> createStagiaire(@RequestBody Stagiaire stagiaire) {
        Stagiaire newStagiaire = stagiaireservice.createStagiaire(stagiaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStagiaire);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id) {
        stagiaireservice.deleteStagiaire(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire stagiaireDetails) {
        Stagiaire updatedStagiaire = stagiaireservice.updateStagiaire(id, stagiaireDetails);
        return ResponseEntity.ok(updatedStagiaire);
    }



}
