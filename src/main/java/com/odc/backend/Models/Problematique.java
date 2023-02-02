package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Entity
public class Problematique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String couleur;
    @Lob
    private String image;


    //////
    @JsonIgnore
    @OneToMany(mappedBy = "problematique",cascade = CascadeType.REMOVE)
    List<Conseil> conseils=new ArrayList<>();

    //le createur de la problematique
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(  name = "jeu_problematique", 
        joinColumns = @JoinColumn(name = "problematique_id"), 
        inverseJoinColumns = @JoinColumn(name = "jeu_id"))
    List<Jeu> jeux = new ArrayList<>();

    //
    //les gamers qui sont interesses par cette problematique
    @JsonIgnore 
    @ManyToMany(mappedBy ="preferences")
    List<User> citoyensIntereses=new ArrayList<>();
}
