package com.odc.backend.Message.Reponse;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JwtResponse {
    
    private String token;
    private String refreshToken;

    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String photo;
    private String nom;
    private String prenom;
    private String telephone;

    private Long point;
    private Long niveau;
    private Date dateSouscription;
    private String Pays;
    private String ville;
    private String adresse;

    private List<String> roles;

    public JwtResponse(String accessToken,String refreshToken, Long id, String username,String email,String telephone, String nom,String prenom, String photo,Long point, Long niveau,Date dateSouscription,String Pays, String ville,String adresse,List<String> roles) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.roles = roles;
        this.point=point;
        this.niveau=niveau;
        this.dateSouscription=dateSouscription;
        this.adresse=adresse;
        this.Pays=Pays;
        this.ville=ville;
        this.telephone=telephone;
      }
}
