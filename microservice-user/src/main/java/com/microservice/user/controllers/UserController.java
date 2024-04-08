package com.microservice.user.controllers;

import com.microservice.user.controllers.dto.UserDTO;
import com.microservice.user.entities.UserEntity;
import com.microservice.user.mapper.UserMapper;
import com.microservice.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/findAllUsers")
    public ResponseEntity<?> findAllUsers() {
        List<UserEntity> userList = userService.findAllUsers();
        List<UserDTO> userDTOList = userList.stream()
                .map(UserMapper::mapToDTO)
                .toList();

        if (userDTOList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        Optional<UserEntity> optionalUser = userService.findUserById(id);

        if (optionalUser.isPresent()) {
            UserDTO userDTO = UserMapper.mapToDTO(optionalUser.get());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search-users-by-project/{id}")
    public ResponseEntity<?> findUsersByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(userService.findUsersByProjectId(projectId));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        try {
            UserEntity userEntity = UserMapper.mapToEntity(user);
            userService.saveUser(userEntity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<UserEntity> optionalUser = userService.findUserById(id);

        if (optionalUser.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
