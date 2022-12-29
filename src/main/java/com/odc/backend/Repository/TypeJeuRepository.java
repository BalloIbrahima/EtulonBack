package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.TypeJeu;
@Repository
public interface TypeJeuRepository extends JpaRepository<TypeJeu,Long>{
    
}
