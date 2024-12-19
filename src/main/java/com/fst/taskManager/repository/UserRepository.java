package com.fst.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fst.taskManager.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username") Optional<User> findByUsernameWithRoles(@Param("username") String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
}
