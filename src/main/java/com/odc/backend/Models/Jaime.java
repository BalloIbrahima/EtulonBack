package com.odc.backend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Jaime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Lob
    // private Long score;

    //
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_conseil")
    private Conseil conseil;

    //
    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
