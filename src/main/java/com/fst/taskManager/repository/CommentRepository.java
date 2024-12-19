package com.fst.taskManager.repository;

import com.fst.taskManager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire, par exemple:
    List<Comment> findByTaskId(Long taskId);
    List<Comment> findByAuthorId(Long authorId);
}
