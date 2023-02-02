package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// @ToString
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

    @Lob
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


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    //les problematiques qui interressent le gamer
    //mes preferences
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(  name = "preferences", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "problematique_id"))
    List<Problematique> preferences = new ArrayList<>();
    //
    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    List<Commentaire> commentaires=new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    List<Conseil> conseils=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    List<Jaime> likes=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    List<Score> scores=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    List<Problematique> problematiques=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    List<Jeu> jeux=new ArrayList<>();

    
}
