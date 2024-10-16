package com.microservice.user.controllers.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String registrationDate;
}
