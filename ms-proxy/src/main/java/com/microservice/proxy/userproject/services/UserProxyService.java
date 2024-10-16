package com.microservice.proxy.userproject.services;

import com.microservice.proxy.userproject.FeignClients.UserFeignClient;
import com.microservice.proxy.userproject.controllers.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProxyService {

    private final UserFeignClient userFeignClient;

    public UserProxyService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public List<UserDTO> findUsersByProject(Long projectId) {
        return userFeignClient.findUsersByProject(projectId);
    }

    public Long findProjectIdByUser(Long userId) {
        return userFeignClient.findProjectIdByUser(userId);
    }
}
