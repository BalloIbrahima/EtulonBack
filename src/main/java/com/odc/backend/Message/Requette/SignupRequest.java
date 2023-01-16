package com.odc.backend.Message.Requette;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.odc.backend.Models.Problematique;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SignupRequest {
    private String nom;
    private String prenom;
    private String username;
    private String telephone;

    private String email;
    private String photo;
    private Date dateSouscription;
    private String Pays;
    private String ville;
    private String adresse;
    
    //
    private Long point;
    private Long niveau;
    private String password;

    List<Problematique> problematiques;

    private List<Problematique> preferences ;

    private Set<String> role;

}
