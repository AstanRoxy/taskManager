package com.fst.taskManager.repository;

import com.fst.taskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire, par exemple:
    List<Task> findByAssignedUserId(Long assignedUserId);
    List<Task> findByDueDateBefore(Date dueDate);
    List<Task> findByStatus(String status);
}
