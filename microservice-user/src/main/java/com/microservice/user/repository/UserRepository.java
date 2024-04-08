package com.microservice.user.repository;

import com.microservice.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.projectId = :projectId")
    List<UserEntity> findUsersByProjectId(Long projectId);
}
