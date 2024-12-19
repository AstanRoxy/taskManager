package com.fst.taskManager.repository;

import com.fst.taskManager.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
    Tag findByName(String name);
}
