package com.example.appPfe.Controller;

import com.example.appPfe.entites.Rapport;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.services.RapportService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rapport")
@CrossOrigin("*")
public class RapportController {

    @Autowired
    private final RapportService rapportService;


    @GetMapping("/getall")
    public List<Rapport> getAllRapport() {
        return rapportService.getAllRapport();
    }

    @GetMapping("/getbytitle/{titre}")
    public ResponseEntity<Rapport> GetRapportByTitre(@PathVariable String titre) {
        Rapport rapport = rapportService.GetRapportByTitre(titre);
        return ResponseEntity.ok(rapport);
    }


    @PostMapping("/add")
    public ResponseEntity<Rapport> CreateRapport(@RequestBody Rapport rapport) {
        Rapport newRapport = rapportService.CreateRapport(rapport);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRapport);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Long id) {
        rapportService.deleteRapport(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable Long id, @RequestBody Rapport rapportDetails) {
        Rapport updatedRapport = rapportService.updateRapport(id, rapportDetails);
        return ResponseEntity.ok(updatedRapport);
    }


}
