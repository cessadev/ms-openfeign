package com.microservice.project.persistence.impl;

import com.microservice.project.entities.ProjectEntity;
import com.microservice.project.persistence.IProjectDAO;
import com.microservice.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectDAOImpl implements IProjectDAO {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<ProjectEntity> findProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void saveProject(ProjectEntity project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
