package com.fst.taskManager.repository;

import com.fst.taskManager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire, par exemple:
    List<Project> findByOwnerId(Long ownerId);
}
