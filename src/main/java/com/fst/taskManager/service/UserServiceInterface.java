package com.fst.taskManager.service;


import java.util.List;

import com.fst.taskManager.dto.UserResponseDto;

public interface UserServiceInterface {
    List<UserResponseDto> getAllClient();
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getClientByRole(String role);
    UserResponseDto create(UserResponseDto userResponseDto);
    UserResponseDto updateClient(Long id, UserResponseDto userResponseDto);
    String deleteClient(Long id);
}
