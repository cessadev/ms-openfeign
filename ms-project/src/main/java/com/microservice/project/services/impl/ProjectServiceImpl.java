package com.microservice.project.services.impl;

import com.microservice.project.entities.ProjectEntity;
import com.microservice.project.persistence.IProjectDAO;
import com.microservice.project.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectDAO.findAllProjects();
    }

    @Override
    public Optional<ProjectEntity> findProjectById(Long id) {
        return projectDAO.findProjectById(id);
    }

    @Override
    public void saveProject(ProjectEntity project) {
        projectDAO.saveProject(project);
    }

    @Override
    public void deleteProject(Long id) {
projectDAO.deleteProject(id);
    }
}
