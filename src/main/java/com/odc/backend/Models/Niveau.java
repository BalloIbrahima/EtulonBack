package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Niveau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    @Lob
    private String image;

    private String description;
    
    @Enumerated(EnumType.STRING)
    private EType typeDescription;
    private String lienDescription;

    /////
    @ManyToOne
    @JoinColumn(name = "id_jeu")
    private Jeu jeu;

    @JsonIgnore
    @OneToMany(mappedBy = "niveau",cascade = CascadeType.REMOVE)
    List<Score> scores=new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(  name = "niveau_question", 
        joinColumns = @JoinColumn(name = "niveau_id"), 
        inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "niveau",cascade = CascadeType.REMOVE)
    List<Jaime> jaimes=new ArrayList<>();
}
