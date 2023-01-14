package com.odc.backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.User;
public interface UserRepository extends JpaRepository<User, Long>{
    //For username
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    //for email
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

    Boolean existsByTelephone(String telephone);

    ///par role
    //List<User> findByRoles(Set<Role> roles);
}
