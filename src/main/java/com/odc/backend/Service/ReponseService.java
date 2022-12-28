package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Reponse;

public interface ReponseService {
    
    // Methode pour la création d'une reponse
    Reponse saveReponse(Reponse reponse);

    // Methode pour la modification d'une reponse
    Reponse updateReponse(Reponse reponse);

    // Methode pour la recuperation d'une reponse
    Reponse getReponse(Long id);

    // Methode pour la surpression d'une reponse à partir d'une reponse
    void deleteReponse(Reponse reponse);

    // Methode pour la liste des reponses à partir d'une reponse
    List<Reponse> getAllReponse();
}
