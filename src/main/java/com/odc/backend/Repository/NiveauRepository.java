package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
    
}
