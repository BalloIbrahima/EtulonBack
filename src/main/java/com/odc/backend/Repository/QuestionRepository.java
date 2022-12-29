package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.Question;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
