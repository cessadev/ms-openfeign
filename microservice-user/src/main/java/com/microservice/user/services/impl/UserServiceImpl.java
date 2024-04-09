package com.microservice.user.services.impl;

import com.microservice.user.entities.UserEntity;
import com.microservice.user.persistence.IUserDAO;
import com.microservice.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserEntity> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public void saveUser(UserEntity user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public List<UserEntity> findUsersByProjectId(Long projectId) {
        return userDAO.findUsersByProjectId(projectId);
    }

    @Override
    public Long findProjectIdByUserId(Long userId) {
        return userDAO.findProjectIdByUserId(userId);
    }
}
