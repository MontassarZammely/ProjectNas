package com.example.appPfe.entites;

import java.util.Date;

public class AssignmentRequest {
    private String nomTache;
    private String descriptionTache;
    private Date deadline;
    private StatuTache status;
    private String nomStagiaire;
    private Long superviseurId;

    // Getters and Setters
    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public StatuTache getStatus() {
        return status;
    }

    public void setStatus(StatuTache status) {
        this.status = status;
    }

    public String getNomStagiaire() {
        return nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }

    public Long getSuperviseurId() {
        return superviseurId;
    }

    public void setSuperviseurId(Long superviseurId) {
        this.superviseurId = superviseurId;
    }
}