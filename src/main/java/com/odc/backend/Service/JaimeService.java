package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Jaime;

public interface JaimeService {
    
    // Methode pour la création d'un jaime
    Jaime saveJaime(Jaime jaime);

    // Methode pour la modification d'un jaime
    Jaime updateJaime(Jaime jaime);

    // Methode pour la recuperation d'un jaime
    Jaime getJaime(Long id);

    // Methode pour la surpression d'un jaime à partir d'un jaime
    void deleteJaime(Jaime jaime);

    // Methode pour la liste des jaimes à partir d'un jaime
    List<Jaime> getAllJaime();

}
