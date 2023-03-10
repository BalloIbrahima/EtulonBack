package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.User;

public interface UserService {
    // Methode pour la création d'un user
    User saveUser(User user);

    // Methode pour la modification d'un user
    /**
     * @param user
     * @return
     */
    User updateUser(User user);

    // Methode pour la recuperation d'un user
    /**
     * @param id
     * @return
     */
    User getUser(Long id);

    // Methode pour la surpression d'un user à partir d'un user
    /**
     * @param user
     */
    void deleteUser(User user);

    // Methode pour la liste des users à partir d'un user
    /**
     * @return
     */
    List<User> getAllUser();

    // Methode pour retrouver un user a travers son username
    /**
     * @param username
     * @return
     */
    User getByUsername(String username);

    // Methode pour retrouver un user a travers son telephone
    /**
     * @param telephone
     * @return
     */
    User getByTelephone(String telephone);

    // Methode pour retrouver un user a travers son adresse email
    /**
     * @param email
     * @return
     */
    User getByEmail(String email);

    //Liste des administrateurs
    List<User> getAllAdmin();

    //Nombre d'administrateurs
    Long NombreAdmin();

    //Liste des citoyens
    List<User> getAllCitoyen();

    //Nombre de citoyen
    Long NombreCitoyen();

    
    // // methode pour la recuperation du nombre de citoyen ayany deja joues aux jeux
    // Long NombreJouersAyantJoues();

    // // methode pour la recuperation du nombre de citoyen ayany deja donnees  des conseils
    // Long NombreJouersAyantConseil();


    List<Jeu> MesJeuxPreferes(Long idUser);

    List<Jeu> MesDerniersjeux(Long idUser, Long nombre);
}
