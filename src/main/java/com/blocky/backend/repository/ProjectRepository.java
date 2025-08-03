package com.blocky.backend.repository;

import com.blocky.backend.entity.Project;
import com.blocky.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByUser_UserId(Integer userId);
}
