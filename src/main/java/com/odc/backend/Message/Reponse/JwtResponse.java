package com.odc.backend.Message.Reponse;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JwtResponse {
    
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String photo;
    private String nom;
    private String prenom;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String username,String email, String nom,String prenom, String photo,List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.photo = photo;
        this.nom = nom;
        this.prenom = prenom;
        this.roles = roles;
      }
}
