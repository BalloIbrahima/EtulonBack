package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Problematique;

public interface ProblematiqueService {
    // Methode pour la création d'un Problematique
    Problematique saveProblematique(Problematique problematique);

    // Methode pour la modification d'un Problematique
    Problematique updateProblematique(Problematique problematique);

    // Methode pour la recuperation d'un Problematique
    Problematique getProblematique(Long id);

    // Methode pour la surpression d'un Problematique à partir d'un Problematique
    void deleteProblematique(Problematique problematique);

    // Methode pour la liste des Problematiques à partir d'un Problematique
    List<Problematique> getAllProblematique();
}
