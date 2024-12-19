package com.fst.taskManager.dto;

import com.fst.taskManager.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTORequest {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles; // Ajustement pour inclure les rôles
}
