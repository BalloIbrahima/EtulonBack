package com.odc.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Conseil;

public interface ConseilRepository extends JpaRepository<Conseil,Long>{
    
}
