package com.microservice.proxy.userproject.controllers;

import com.microservice.proxy.userproject.controllers.dto.ProjectDTO;
import com.microservice.proxy.userproject.controllers.dto.UserDTO;
import com.microservice.proxy.userproject.services.ProjectProxyService;
import com.microservice.proxy.userproject.services.UserProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-project")
public class UserProxyController {
    @Autowired
    private UserProxyService userProxyService;

    @Autowired
    private ProjectProxyService projectProxyService;

    @GetMapping("/search-users-by-project/{projectId}")
    public ResponseEntity<List<UserDTO>> findUsersByProject(@PathVariable Long projectId) {
        List<UserDTO> users = userProxyService.findUsersByProject(projectId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/find-project-by-user/{userId}")
    public ResponseEntity<ProjectDTO> findProjectInfoByUser(@PathVariable Long userId) {
        Long projectId = userProxyService.findProjectIdByUser(userId);
        if (projectId != null) {
            ProjectDTO projectDTO = projectProxyService.findProjectById(projectId);
            return ResponseEntity.ok(projectDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
