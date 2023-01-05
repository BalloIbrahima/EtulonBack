package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.User;

public interface UserService {
    // Methode pour la création d'un user
    User saveUser(User user);

    // Methode pour la modification d'un user
    User updateUser(User user);

    // Methode pour la recuperation d'un user
    User getUser(Long id);

    // Methode pour la surpression d'un user à partir d'un user
    void deleteUser(User user);

    // Methode pour la liste des users à partir d'un user
    List<User> getAllUser();

    // Methode pour retrouver un user a travers son username
    User getByUsername(String username);

    // Methode pour retrouver un user a travers son adresse email
    User getByEmail(String email);

    //Liste des administrateurs
    List<User> getAllAdmin();

    //Nombre d'administrateurs
    Long NombreAdmin();

    //Liste des citoyens
    List<User> getAllCitoyen();

    //Nombre de citoyen
    Long NombreCitoyen();
}
