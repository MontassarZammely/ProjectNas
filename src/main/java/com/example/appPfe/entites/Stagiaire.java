package com.example.appPfe.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idStagiaire")
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStagiaire;
    private String nomStagiaire;
    private String prenomStagiaire;
    private String emailStagiaire;
    private String adresseStagiaire;
    private String telephoneStagiaire;
    private String mdpStagiaire;
    private Date DateD_Stage;
    private Date DateF_Stage;
    private Role role;

    @OneToMany(mappedBy = "stagiaire", cascade = CascadeType.ALL)
    private List<Tache> taches;



    public Stagiaire(Long idStagiaire) {
        this.idStagiaire = idStagiaire;
    }
}
