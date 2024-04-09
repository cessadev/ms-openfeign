package com.microservice.project.mapper;

import com.microservice.project.controllers.dto.ProjectDTO;
import com.microservice.project.entities.ProjectEntity;

public class ProjectMapper {

    public static ProjectDTO mapToDTO(ProjectEntity project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
    }

    public static ProjectEntity mapToEntity(ProjectDTO projectDTO) {
        return ProjectEntity.builder()
                .id(projectDTO.getId())
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .build();
    }
}
