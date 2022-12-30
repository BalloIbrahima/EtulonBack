package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Question;
public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
