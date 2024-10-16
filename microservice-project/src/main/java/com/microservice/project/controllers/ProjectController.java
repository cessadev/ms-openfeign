package com.microservice.project.controllers;

import com.microservice.project.controllers.dto.ProjectDTO;
import com.microservice.project.entities.ProjectEntity;
import com.microservice.project.mapper.ProjectMapper;
import com.microservice.project.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/findAllProjects")
    public ResponseEntity<?> findAllProjects() {
        List<ProjectEntity> projectList = projectService.findAllProjects();
        List<ProjectDTO> projectDTOList = projectList.stream()
                .map(ProjectMapper::mapToDTO)
                .toList();

        if (projectDTOList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectDTOList);
    }

    @GetMapping("/findProjectById/{id}")
    public ResponseEntity<?> findProjectById(@PathVariable Long id) {
        Optional<ProjectEntity> optionalProject = projectService.findProjectById(id);

        if (optionalProject.isPresent()) {
            ProjectDTO projectDTO = ProjectMapper.mapToDTO(optionalProject.get());
            return ResponseEntity.ok(projectDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveProject")
    public ResponseEntity<?> saveProject(@RequestBody ProjectDTO projectDTO) {
        try {
            ProjectEntity projectEntity = ProjectMapper.mapToEntity(projectDTO);
            projectService.saveProject(projectEntity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        Optional<ProjectEntity> optionalProject = projectService.findProjectById(id);

        if (optionalProject.isPresent()) {
            projectService.deleteProject(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
