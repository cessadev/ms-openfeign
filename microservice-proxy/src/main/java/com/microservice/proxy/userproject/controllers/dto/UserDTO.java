package com.microservice.proxy.userproject.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String registrationDate;
    private Long projectId;
}
