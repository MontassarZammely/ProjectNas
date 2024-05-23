package com.example.appPfe.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import static com.example.appPfe.entites.StatuTache.ANNULE;
import static com.example.appPfe.entites.StatuTache.ENCOURS;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTache")
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTache;
    private String nomTache;
    private String descriptionTache;
    private Date deadline;
    private StatuTache status = ENCOURS;

    @ManyToOne
    @JoinColumn(name = "stagiaire_id")
    private Stagiaire stagiaire;

    @ManyToOne
    @JoinColumn(name = "superviseur_id")
    private Superviseur superviseur;
}
