package com.microservice.proxy.userproject.services;

import com.microservice.proxy.userproject.FeignClients.ProjectFeignClient;
import com.microservice.proxy.userproject.controllers.dto.ProjectDTO;
import org.springframework.stereotype.Service;

@Service
public class ProjectProxyService {

    private final ProjectFeignClient projectFeignClient;

    public ProjectProxyService(ProjectFeignClient projectFeignClient) {
        this.projectFeignClient = projectFeignClient;
    }

    public ProjectDTO findProjectById(Long projectId) {
        return projectFeignClient.findProjectById(projectId);
    }
}
