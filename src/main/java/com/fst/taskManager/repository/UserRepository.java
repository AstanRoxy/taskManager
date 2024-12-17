package com.fst.taskManager.repository;

import com.fst.taskManager.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String name);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}