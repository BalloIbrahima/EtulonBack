package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String telephone;

    private String photo;
    private String password;
    private Date dateSouscription;

    //location
    private String Pays;
    private String ville;
    private String adresse;


    //
    private Long point;
    private Long niveau;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    //les problematiques qui interressent le gamer
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "centre_interets", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "problematique_id"))
    private Set<Problematique> interets = new HashSet<>();
    //
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Commentaire> commentaires=new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Conseil> conseils=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Jaime> likes=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Score> scores=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Problematique> problematiques=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Jeu> jeux=new ArrayList<>();
}
