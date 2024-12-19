package com.fst.taskManager.service;

import com.fst.taskManager.model.Role;
import com.fst.taskManager.model.User;
import com.fst.taskManager.repository.RoleRepository;
import com.fst.taskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void registerUser(User user) {
        // Attribuer le rôle par défaut "USER"
        Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Error: Role USER is not found."));
        user.setRoles(new HashSet<>(Collections.singleton(userRole)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Authentication authenticate(String username, String password) {
        try {
            // Charger l'utilisateur par son nom d'utilisateur avec ses rôles
            User user = userRepository.findByUsernameWithRoles(username).orElseThrow(() ->
                new RuntimeException("Utilisateur non trouvé: " + username));

            // Comparer le mot de passe fourni avec le mot de passe haché
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new RuntimeException("Les identifications sont erronées");
            }

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            return authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Les identifications sont erronées");
        }
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
