package com.fst.taskManager.service;

import com.fst.taskManager.Enum.ERole;
import com.fst.taskManager.dto.UserResponseDto;

import com.fst.taskManager.exception.RessourceNotFoundException;
import com.fst.taskManager.mapper.Mapper;
import com.fst.taskManager.mapper.MyMapper;
import com.fst.taskManager.model.Role;
import com.fst.taskManager.model.User;
import com.fst.taskManager.repository.RoleRepository;
import com.fst.taskManager.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    public MyMapper myMapper;

    @Override
    public List<UserResponseDto> getAllClient() {
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RessourceNotFoundException("Aucun client trouver"));
        return new UserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getClientByRole(String role) {
        Role modRole;
        if(Objects.equals(role, "client"))
             modRole = roleRepository.findByName(ERole.ROLE_CLIENT).orElseThrow(()->new RessourceNotFoundException("Aucun client trouver"));
        else {
            modRole = new Role();
        }
        return userRepository.findAll().stream()
                .filter(user1 -> user1.getRoles().stream()
                .anyMatch(role1 -> role1.getName() == modRole.getName()))
                .map(UserResponseDto::new)
                .toList();
    }

    @Override
    public UserResponseDto create(UserResponseDto userResponseDto) {
        User user =Mapper.getMapper().map(userResponseDto, User.class);
        /*if(userRepository.existsByName(user.getName()))
            throw new ConflictRessourceException("Ce nom existe déjà");*/
        userRepository.save(user);
        return Mapper.getMapper().map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto updateClient(Long id, UserResponseDto userResponseDto) {
        User user =Mapper.getMapper().map(userResponseDto, User.class);
        user.setId(id);
        User oldUser = userRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Ce client n'existe pas"));
       /* if( (userRepository.existsByName(user.getName()) & ! Objects.equals(oldUser.getName(), user.getName())))
            throw new ConflictRessourceException("Ce nom existe déjà");*/
        userRepository.save(user);
        return Mapper.getMapper().map(user, UserResponseDto.class);
    }

    @Override
    public String deleteClient(Long id) {
        if(userRepository.findById(id).isEmpty())
            throw new RessourceNotFoundException("Ce client n'existe pas");
        userRepository.deleteById(id);
        return "Client supprimer avec succès";
    }
}