package com.microservice.project.persistence;

import com.microservice.project.entities.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface IProjectDAO {
    List<ProjectEntity> findAllProjects();
    Optional<ProjectEntity> findProjectById(Long id);
    void saveProject(ProjectEntity project);
    void deleteProject(Long id);
}
