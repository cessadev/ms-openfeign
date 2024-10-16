package com.microservice.proxy.userproject.FeignClients;

import com.microservice.proxy.userproject.controllers.dto.ProjectDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-project", url = "localhost:8080/api/project")
public interface ProjectFeignClient {

    @GetMapping("/findProjectById/{projectId}")
    ProjectDTO findProjectById(@PathVariable Long projectId);
}
