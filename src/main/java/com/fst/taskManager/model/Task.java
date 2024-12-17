package com.fst.taskManager.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    @Version
    private Long version; // Pour le contrôle de version

    @ManyToOne // Une tâche appartient à un utilisateur
    @JoinColumn(name = "user_id") // Clé étrangère
    private User user;

    @ManyToOne // Une tâche appartient à une catégorie
    @JoinColumn(name = "category_id") // Clé étrangère
    private Category category;
}
