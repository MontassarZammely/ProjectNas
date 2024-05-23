package com.example.appPfe.Controller;


import com.example.appPfe.entites.Pointage;
import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.entites.Tache;
import com.example.appPfe.entites.pointageDTO;
import com.example.appPfe.services.PointageService;
import com.example.appPfe.services.StagiaireService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pointage")
@CrossOrigin("*")
public class PointageController {


    @Autowired
    private final PointageService pointageService;


    @Autowired
    private final StagiaireService stagiaireService;

    @GetMapping("/getall")
    public List<Pointage> getAllPointages() {
        return pointageService.getAllPointages();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pointage> getPointageById(@PathVariable Long id) {
        Pointage pointage = pointageService.getpointageById(id);
        return ResponseEntity.ok(pointage);
    }

    @PostMapping("/add")
    public ResponseEntity<Pointage> createPointage(@RequestBody Pointage pointage) {
        Pointage newPointage = pointageService.createPointage(pointage);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPointage);
    }




    @GetMapping("/get/{id}")
    public ResponseEntity<pointageDTO> getPointageById(@PathVariable Long id) {
        Pointage pointage = pointageService.getpointageById(id);
        pointageDTO pointageDTO = modelMapper.map(pointage, pointageDTO.class);
        return ResponseEntity.ok(pointageDTO);
    }


}

