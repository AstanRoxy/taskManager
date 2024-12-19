/*package com.fst.taskManager.mapper;

import com.fst.taskManager.Enum.ERole;
import com.fst.taskManager.dto.UserResponseDto;
import com.fst.taskManager.model.Role;
import com.fst.taskManager.model.User;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {
    @Bean
    public static ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(User.class, UserResponseDto.class).addMappings(mapper ->
                mapper.<Set<ERole>>map(src -> src.getRoles().stream()
                                .map(Role::getName)
                                .collect(Collectors.toSet()),
                        UserResponseDto::setRole)
        );

        return modelMapper;

    }
}*/
