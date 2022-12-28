package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.TypeJeu;

public interface TypeJeuService {
    
    // Methode pour la création d'un type
    TypeJeu saveTypeJeu(TypeJeu type);

    // Methode pour la modification d'un type
    TypeJeu updateTypeJeu(TypeJeu type);

    // Methode pour la recuperation d'un type
    TypeJeu getTypeJeu(Long id);

    // Methode pour la surpression d'un type à partir d'un type
    void deleteTypeJeu(TypeJeu type);

    // Methode pour la liste des types à partir d'un type
    List<TypeJeu> getAllTypeJeu();
}
