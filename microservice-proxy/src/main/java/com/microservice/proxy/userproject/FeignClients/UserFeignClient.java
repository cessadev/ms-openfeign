package com.microservice.proxy.userproject.FeignClients;

import com.microservice.proxy.userproject.controllers.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-user", url = "localhost:8080/api/user")
public interface UserFeignClient {

    @GetMapping("/search-users-by-project/{projectId}")
    List<UserDTO> findUsersByProject(@PathVariable Long projectId);

    @GetMapping("/find-projectid-by-user/{userId}")
    Long findProjectIdByUser(@PathVariable Long userId);
}
