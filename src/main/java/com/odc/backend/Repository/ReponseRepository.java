package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.Reponse;
@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long>{
    
}
