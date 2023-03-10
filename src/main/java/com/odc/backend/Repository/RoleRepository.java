package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.ERole;
import com.odc.backend.Models.Role;
public interface RoleRepository extends JpaRepository<Role,Long>{
    
    Role findByName(ERole name);
}
