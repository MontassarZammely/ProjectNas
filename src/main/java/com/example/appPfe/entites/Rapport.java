package com.example.appPfe.entites;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRapport;
    private String titre;
    private String file;


    @ManyToOne
    @JoinColumn(name = "idStagiaire") // Le nom de la colonne dans la table Rapport faisant référence à l'id du stagiaire
    private Stagiaire stagiaire;

    @ManyToOne
    @JoinColumn(name = "idSuperviseur") // Le nom de la colonne dans la table Rapport faisant référence à l'id du superviseur
    private Superviseur superviseur;

}
