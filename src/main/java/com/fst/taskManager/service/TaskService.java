package com.fst.taskManager.service;

import com.fst.taskManager.exception.CustomException;
import com.fst.taskManager.model.Task;
import com.fst.taskManager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        try {
            return taskRepository.save(task); // Retourner l'objet Task
        } catch (OptimisticLockingFailureException e) {
            // Gérer le conflit ici, par exemple, en informant l'utilisateur
            throw new CustomException("La tâche a été modifiée par un autre utilisateur.", e);
        }
    }

    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
