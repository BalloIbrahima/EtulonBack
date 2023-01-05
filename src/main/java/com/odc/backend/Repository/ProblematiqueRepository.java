package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Problematique;

public interface ProblematiqueRepository  extends JpaRepository<Problematique,Long>{
    
}
