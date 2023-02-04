package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.User;

public interface JeuService {
    
    // Methode pour la création d'un jeu
    Jeu saveJeu(Jeu jeu);

    // Methode pour la modification d'un jeu
    Jeu updateJeu(Jeu jeu);

    // Methode pour la recuperation d'un jeu
    Jeu getJeu(Long id);

    // Methode pour la surpression d'un jeu à partir d'un jeu
    void deleteJeu(Jeu jeu);

    // Methode pour la liste des jeux
    List<Jeu> getAllJeu();

    // Methode pour la liste des jeux les plux joues
    List<Jeu> getJeuPlus(Long nombre);

    // Methode pour la lrecuperation des joueurs  d'un jeu
    List<User> getAllCitoyen(Long id);

    // Methode pour la la recuperation du nombre de jeu effectuer sur un jeu
    Long getNbreFoisJeu(Long id);

    // Methode pour la la recuperation des  jeus  joues par un joueur
    List<Jeu> getNbreJeuJou(Long id);

    // Methode pour la la recuperation du nombre de like dun jeu 
    Long getNbreLike(Long id);

    //recuperation des 20 derniers jeu
    List<Jeu> Last20Derniers();
}
