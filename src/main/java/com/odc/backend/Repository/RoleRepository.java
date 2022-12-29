package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    
}
