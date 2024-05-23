package com.example.appPfe.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StagiaireDTO {

    private Long idStagiaire;
    private String nomStagiaire;
    private String emailStagiaire;
    private String telephoneStagiaire;

}
