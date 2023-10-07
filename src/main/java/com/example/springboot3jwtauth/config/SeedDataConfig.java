package com.example.springboot3jwtauth.config;

import com.example.springboot3jwtauth.models.User;
import com.example.springboot3jwtauth.repositories.UserRepository;
import com.example.springboot3jwtauth.services.UserService;
import com.example.springboot3jwtauth.util.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class SeedDataConfig implements CommandLineRunner {

  private final  UserRepository userRepository;
  private final  PasswordEncoder passwordEncoder;
  private final  UserService userService;
    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            User admin = User
                    .builder()
                    .firstName("admin")
                    .lastName("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("password"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userService.save(admin);
            log.debug("created ADMIN user - {}", admin);
        }
    }
}
