package com.microservice.user.persistence.impl;

import com.microservice.user.entities.UserEntity;
import com.microservice.user.persistence.IUserDAO;
import com.microservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(UserEntity user) { userRepository.save(user); }

    @Override
    public void deleteUser(Long id) { userRepository.deleteById(id); }

    @Override
    public List<UserEntity> findUsersByProjectId(Long projectId) { return userRepository.findUsersByProjectId(projectId); }
}
