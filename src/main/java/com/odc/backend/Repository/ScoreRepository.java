package com.odc.backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Score;
import com.odc.backend.Models.User;

public interface ScoreRepository extends JpaRepository<Score,Long>{
    
    List<Score> findByUser(User user);
}
