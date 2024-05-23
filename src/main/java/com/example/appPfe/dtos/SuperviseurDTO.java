package com.example.appPfe.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperviseurDTO {

    private Long idSuperviseur;
    private String nomSuperviseur;
    private String telephoneSuperviseur;
    private String emailSuperviseur;


}
