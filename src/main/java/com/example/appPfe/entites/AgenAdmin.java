package com.example.appPfe.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString @Getter @Setter @Builder
public class AgenAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAgent;
    private String nomAgent;
    private String prenomAgent;
    private String adresseAgent;
    private String telephoneAgent;
    private String emailAgent;
    private String mdpAgent;
    private Role role;

}
