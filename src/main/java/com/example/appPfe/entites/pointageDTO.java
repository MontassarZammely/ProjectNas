package com.example.appPfe.entites;

import java.time.LocalDateTime;

public class pointageDTO {

    private Long idp;
    private LocalDateTime pointageEntre;
    private LocalDateTime pointageSortie;
    private int retard;
    private Long stagiaireId;


    public pointageDTO() {
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public LocalDateTime getPointageEntre() {
        return pointageEntre;
    }

    public void setPointageEntre(LocalDateTime pointageEntre) {
        this.pointageEntre = pointageEntre;
    }

    public LocalDateTime getPointageSortie() {
        return pointageSortie;
    }

    public void setPointageSortie(LocalDateTime pointageSortie) {
        this.pointageSortie = pointageSortie;
    }

    public int getRetard() {
        return retard;
    }

    public void setRetard(int retard) {
        this.retard = retard;
    }

    public Long getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(Long stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    public pointageDTO(Long idp, LocalDateTime pointageEntre, LocalDateTime pointageSortie, int retard, Long stagiaireId) {
        this.idp = idp;
        this.pointageEntre = pointageEntre;
        this.pointageSortie = pointageSortie;
        this.retard = retard;
        this.stagiaireId = stagiaireId;
    }
}
