package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Score;

public interface ScoreRepository extends JpaRepository<Score,Long>{
    
}
