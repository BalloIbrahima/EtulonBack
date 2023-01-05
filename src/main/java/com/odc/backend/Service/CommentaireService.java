package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Commentaire;

public interface CommentaireService {
    
    // Methode pour la création d'un Commentaire
    Commentaire saveCommentaire(Commentaire commentaire);

    // Methode pour la modification d'un Commentaire
    Commentaire updateCommentaire(Commentaire commentaire);

    // Methode pour la recuperation d'un Commentaire
    Commentaire getCommentaire(Long id);

    // Methode pour la surpression d'un Commentaire à partir d'un Commentaire
    void deleteCommentaire(Commentaire commentaire);

    // Methode pour la liste des Commentaires à partir d'un Commentaire
    List<Commentaire> getAllCommentaire();

}
