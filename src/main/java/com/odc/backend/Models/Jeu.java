package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Jeu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String image;
    
    private Date date;

    @Enumerated(EnumType.STRING)
    private ENiveau niveau;

    @Lob
    private String description;
    
    @Enumerated(EnumType.STRING)
    private EType typeDescription;
    @Lob
    private String lienDescription;

    private Long nbreLike;

    private Long nbreJoues;

    ////
    @JsonIgnore
    @ManyToMany(mappedBy ="jeux")
    List<Problematique> problematiques=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "jeu",cascade = CascadeType.REMOVE)
    List<Niveau> niveaux=new ArrayList<>();


}
