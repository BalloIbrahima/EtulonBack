package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Niveau;

public interface NiveauService {
    // Methode pour la création d'un Niveau
    Niveau saveNiveau(Niveau niveau);

    // Methode pour la modification d'un Niveau
    Niveau updateNiveau(Niveau niveau);

    // Methode pour la recuperation d'un Niveau
    Niveau getNiveau(Long id);

    // Methode pour la surpression d'un Niveau à partir d'un Niveau
    void deleteNiveau(Niveau niveau);

    // Methode pour la liste des Niveaus à partir d'un Niveau
    List<Niveau> getAllNiveau();

}
