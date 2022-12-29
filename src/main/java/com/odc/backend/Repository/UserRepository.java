package com.odc.backend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.backend.Models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    //For username
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    //for email
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
