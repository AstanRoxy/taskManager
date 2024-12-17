package com.fst.taskManager.repository;

import com.fst.taskManager.Enum.ERole;
import com.fst.taskManager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
