package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Conseil;

public interface ConseilService {
    
    // Methode pour la création d'un conseil
    Conseil saveConseil(Conseil conseil);

    // Methode pour la modification d'un conseil
    Conseil updateConseil(Conseil conseil);

    // Methode pour la recuperation d'un conseil
    Conseil getConseil(Long id);

    // Methode pour la surpression d'un conseil à partir d'un conseil
    void deleteConseil(Conseil conseil);

    // Methode pour la liste des conseils à partir d'un conseil
    List<Conseil> getAllConseil();

}
