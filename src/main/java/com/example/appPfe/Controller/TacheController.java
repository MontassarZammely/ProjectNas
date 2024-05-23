package com.example.appPfe.Controller;

import com.example.appPfe.entites.AssignmentRequest;
import com.example.appPfe.entites.StatuTache;
import com.example.appPfe.entites.Tache;
import com.example.appPfe.entites.TacheDTO;
import com.example.appPfe.services.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tache")
@CrossOrigin("*")
public class TacheController {

    @Autowired
    private final TacheService tacheService;

    @GetMapping("/getall")
    public List<Tache> getAll() {
        return tacheService.getAllTaches();
    }

    @PostMapping("/add")
    public ResponseEntity<TacheDTO> createAndAssignTache(@RequestBody AssignmentRequest request) {
        try {
            TacheDTO newTache = tacheService.createAndAssignTache(
                    request.getNomTache(),
                    request.getDescriptionTache(),
                    request.getDeadline(),
                    StatuTache.valueOf(request.getStatus().toString()),
                    request.getNomStagiaire(),
                    request.getSuperviseurId()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(newTache);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PutMapping("/{tacheId}/statut")
    public ResponseEntity<String> updateTacheStatut(@PathVariable Long tacheId, @RequestParam StatuTache newStatut) {
        tacheService.updateTacheStatut(tacheId, newStatut);
        return new ResponseEntity<>("Statut de la tâche mis à jour avec succès", HttpStatus.OK);
    }




}
