package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.User;

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

    // Methode pour la liste des conseils actives
    List<Conseil> getAllConseilActive();

    // Methode pour la liste des conseils non actives
    List<Conseil> getAllConseilNonActive();

    // Methode pour la liste des conseils non actives
    List<Conseil> getAllConseiltRejetes();

    //recuperation des conseils en fonction des centres d'interets
    List<Conseil> getByUserInterets(Long id);

    //recuperation des conseils en fonction dun user
    List<Conseil> getByUser(User user);

    //recuperation des conseils en fonction des plus aimes
    List<Conseil> getByAimes(Long id);



}
