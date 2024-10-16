package com.microservice.project.controllers.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;
}
