package com.example.appPfe.Controller;


import com.example.appPfe.entites.Stagiaire;
import com.example.appPfe.entites.autorisation;
import com.example.appPfe.services.autorisationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autorisation")
public class autorisationController {

    @Autowired
    private final autorisationService service;


    @GetMapping("/getall")
    public List<autorisation> getAll() {
        return service.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<autorisation> getById(@PathVariable Long id) {
        autorisation Autorisation = service.getAutorisationById(id);
        return ResponseEntity.ok(Autorisation);
    }

    @PostMapping("/add")
    public ResponseEntity<autorisation> addAutorisation(@RequestBody autorisation Autorisation) {
        autorisation newAutorisation = service.addAutorisation(Autorisation);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAutorisation);
    }
    

}
