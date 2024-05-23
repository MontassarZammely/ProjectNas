package com.example.appPfe.Controller;


import com.example.appPfe.dtos.SuperviseurDTO;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.entites.Superviseur;
import com.example.appPfe.services.SuperviseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superviseur")
@CrossOrigin("*")
public class SuperviseurController {

    @Autowired
    private final SuperviseurService superviseurService;

    @GetMapping("/getall")
    public List<Superviseur> getAllSuperviseurs(){
        return superviseurService.getAllSuperviseurs();
    }
    @GetMapping("/get")
    public List<SuperviseurDTO> getAllSuperviseursDTO(){
        return superviseurService.getAllSuperviseursDTO();
    }

    @PostMapping("/add")
    public ResponseEntity<Superviseur> CreateSuperviseur(@RequestBody Superviseur superviseur) {
        Superviseur newSuperviseur = superviseurService.CreateSuperviseur(superviseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSuperviseur);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteSuperviseur(@PathVariable Long id) {
        superviseurService.DeleteSuperviseur(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Superviseur> updateSuperviseur(@PathVariable Long id, @RequestBody Superviseur superviseurDetails) {
        Superviseur updatedSuperviseur = superviseurService.updateSuperviseur(id, superviseurDetails);
        return ResponseEntity.ok(updatedSuperviseur);
    }

}
