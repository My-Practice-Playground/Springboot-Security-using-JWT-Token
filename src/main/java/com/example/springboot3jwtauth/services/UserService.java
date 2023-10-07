package com.example.springboot3jwtauth.services;

import com.example.springboot3jwtauth.models.User;
import com.example.springboot3jwtauth.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public UserDetailsService userDetailsService() {
        return new UserDetails() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                return userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
            }
        };
    }

    public User save(User newUser) {
        if (newUser.getId() == null) {
            newUser.setCreatedAt(LocalDateTime.now());
        }
        newUser.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(newUser);
    }
}


