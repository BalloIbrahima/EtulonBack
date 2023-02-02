package com.odc.backend.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
//@ToString
public class Conseil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    @Lob
    private String contenu;

    private String color;
    private Long nbreLike;

    private Date date;

    ///attribut specifique au type de conseil
    
    @Enumerated(EnumType.STRING)
    private EType type;
    
    @Lob
    private String lien;

    ////
    @JsonIgnore
    @OneToMany(mappedBy = "conseil",cascade = CascadeType.REMOVE)
    List<Commentaire> commentaires=new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "conseil", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "id_problematique")
    private Problematique problematique;


    @OneToMany(mappedBy = "conseil",cascade = CascadeType.REMOVE)
    List<Jaime> likes=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
