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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long numero;
    @Lob
    private String contenu;
    private Long timer;
    private Long point;

    @Enumerated(EnumType.STRING)
    private EType type;
    @Lob
    private String lien;

    ////
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(  name = "question_reponse", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "reponse_id"))
    private List<Reponse> reponses = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "questions",cascade = CascadeType.REMOVE)
    List<Niveau> niveau=new ArrayList<>();

}
