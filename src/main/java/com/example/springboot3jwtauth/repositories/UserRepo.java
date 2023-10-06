package com.example.springboot3jwtauth.repositories;

import com.example.springboot3jwtauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);
}
