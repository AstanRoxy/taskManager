package com.fst.taskManager.dto.security.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

    // getters and setters
}
