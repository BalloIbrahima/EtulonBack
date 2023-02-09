package com.odc.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Jeu;
import com.odc.backend.Models.Problematique;
public interface JeuRepository  extends JpaRepository<Jeu, Long>{
    
    Jeu findByNom(String nom);

    List<Jeu> findTop20ByOrderByDateDesc();

    List<Jeu> findAllByOrderByNbreLikeDesc();

    List<Jeu> findTop40ByOrderByNbreJouesDesc();

    List<Jeu> findByProblematiques(Problematique problematiques);

}
