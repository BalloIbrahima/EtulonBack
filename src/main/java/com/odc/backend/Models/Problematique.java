package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Entity
@ToString
public class Problematique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String couleur;
    private String image;


    //////
    @JsonIgnore
    @OneToMany(mappedBy = "problematique")
    List<Conseil> conseils=new ArrayList<>();

    //le createur de la problematique
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "problematique")
    List<Jeu> jeux=new ArrayList<>();

    //
    //les gamers qui sont interesses par cette problematique
    @JsonIgnore
    @ManyToMany(mappedBy ="interets" )
    List<User> users=new ArrayList<>();
}
