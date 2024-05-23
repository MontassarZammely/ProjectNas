package com.example.appPfe.entites;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TacheDTO {
    private String nomTache;
    private String descriptionTache;
    private Date deadline;
    private String status;
    private String nomStagiaire;
    private String nomSuperviseur;
}