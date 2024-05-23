package com.example.appPfe.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idp;
    private LocalDateTime pointageEntre;
    private LocalDateTime pointageSortie;
    private int retard;



    @ManyToOne
    @JoinColumn(name = "idStagiaire")
    private Stagiaire stagiaire;

}
