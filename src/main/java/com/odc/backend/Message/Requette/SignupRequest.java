package com.odc.backend.Message.Requette;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SignupRequest {
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String photo;
   
    private String password;

    private Set<String> role;

}
