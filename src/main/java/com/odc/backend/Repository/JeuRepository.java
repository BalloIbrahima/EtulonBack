package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Jeu;

public interface JeuRepository  extends JpaRepository<Jeu, Long>{
    
    Jeu findByNom(String nom);
}
