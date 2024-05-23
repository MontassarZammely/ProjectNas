package com.example.appPfe.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSuperviseur")
public class Superviseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSuperviseur;
    private String nomSuperviseur;
    private String prenomSuperviseur;
    private String adresseSuperviseur;
    private String telephoneSuperviseur;
    private String emailSuperviseur;
    private String mdpSuperviseur;
    private Role role;

    @OneToMany(mappedBy = "superviseur", cascade = CascadeType.ALL)
    private List<Tache> taches;
}
