package com.odc.backend.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Role;
import com.odc.backend.Models.User;
public interface UserRepository extends JpaRepository<User, Long>{
    //For username
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    //for email
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);


    ///par role
    List<User> findByRoles(Set<Role> roles);
}
