package com.microservice.user.services;

import com.microservice.user.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserEntity> findAllUsers();
    Optional<UserEntity> findUserById(Long id);
    void saveUser(UserEntity user);
    void deleteUser(Long id);
    List<UserEntity> findUsersByProjectId(Long projectId);
}
