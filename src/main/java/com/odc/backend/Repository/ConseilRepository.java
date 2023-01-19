package com.odc.backend.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Conseil;
import com.odc.backend.Models.Problematique;
public interface ConseilRepository extends JpaRepository<Conseil,Long>{
    
    List<Conseil> findByProblematique(Problematique problematique);
}
