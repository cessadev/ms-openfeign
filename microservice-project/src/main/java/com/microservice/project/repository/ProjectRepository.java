package com.microservice.project.repository;

import com.microservice.project.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    @Query("SELECT p FROM ProjectEntity p JOIN UserEntity u ON p.id = u.projectId WHERE u.id = :userId")
    ProjectEntity findProjectByUserId(Long userId);
}
