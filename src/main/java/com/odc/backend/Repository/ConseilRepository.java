package com.odc.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.Conseil;
@Repository
public interface ConseilRepository extends JpaRepository<Conseil,Long>{
    
}
