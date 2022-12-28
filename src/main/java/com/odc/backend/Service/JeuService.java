package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Jeu;

public interface JeuService {
    
    // Methode pour la création d'un jeu
    Jeu saveJeu(Jeu jeu);

    // Methode pour la modification d'un jeu
    Jeu updateJeu(Jeu jeu);

    // Methode pour la recuperation d'un jeu
    Jeu getJeu(Long id);

    // Methode pour la surpression d'un jeu à partir d'un jeu
    void deleteJeu(Jeu jeu);

    // Methode pour la liste des jeus à partir d'un jeu
    List<Jeu> getAllJeu();
}
