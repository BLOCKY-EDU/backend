package com.blocky.backend.repository;

import com.blocky.backend.dto.ProjectSummaryResponse;
import com.blocky.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
        select new com.blocky.backend.dto.ProjectSummaryResponse(p.projectId, p.title, p.createdAt)
        from Project p
        order by p.projectId desc
    """)
    List<ProjectSummaryResponse> findAllSummaries();

    @Query("""
        select new com.blocky.backend.dto.ProjectSummaryResponse(p.projectId, p.title, p.createdAt)
        from Project p
        where p.userId = :userId
        order by p.projectId desc
    """)
    List<ProjectSummaryResponse> findSummariesByUserId(@Param("userId") Integer userId);
}
