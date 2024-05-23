package com.example.appPfe.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class autorisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAut;
    private String Justification;
    private Date date;
    private statuAut status;
    private int autorisationRestant = 3 ;


    @ManyToOne
    @JoinColumn(name = "idStagiaire")
    private Stagiaire stagiaire;

    @ManyToOne
    @JoinColumn(name = "idSuperviseur")
    private Superviseur superviseur;
}
