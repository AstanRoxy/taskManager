package com.fst.taskManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fst.taskManager.dto.UserResponseDto;
import com.fst.taskManager.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllClient();
    }

    // Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserResponseDto user) {
        UserResponseDto createdUser = userService.create(user);
        return ResponseEntity.ok(createdUser);
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public UserResponseDto getOne(@PathVariable(value = "id") Long id){return userService.getUserById(id);}


    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        return userService.deleteClient(id);
    }

    // Mise à jour d'un utilisateur
    @PutMapping(path = "/{id}")
    public UserResponseDto update(@RequestBody UserResponseDto userResponseDto, @PathVariable(value = "id") Long id){
        return userService.updateClient(id, userResponseDto);
    }
}