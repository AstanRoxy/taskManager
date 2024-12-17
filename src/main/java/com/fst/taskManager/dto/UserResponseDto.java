package com.fst.taskManager.dto;

import com.fst.taskManager.Enum.ERole;
import com.fst.taskManager.model.Role;
import com.fst.taskManager.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDto {
    private String username;
    private String email;
    private Set<ERole> role;
    private String password;
    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        // Convertir Set<Role> en Set<ERole>
        if (user.getRoles() != null) {
            this.role = user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());
        }
    }
}