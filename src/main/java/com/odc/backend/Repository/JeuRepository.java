package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.Jeu;
@Repository
public interface JeuRepository  extends JpaRepository<Jeu, Long>{
    
    Jeu findByNom(String nom);
}
