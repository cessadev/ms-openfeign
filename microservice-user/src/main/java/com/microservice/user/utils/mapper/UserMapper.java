package com.microservice.user.utils.mapper;

import com.microservice.user.controllers.dto.UserDTO;
import com.microservice.user.entities.UserEntity;

public class UserMapper {

    public static UserDTO mapToDTO(UserEntity user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .registrationDate(user.getRegistrationDate())
                .build();
    }

    public static UserEntity mapToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .registrationDate(userDTO.getRegistrationDate())
                .build();
    }
}
