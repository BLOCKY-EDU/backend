package com.blocky.backend.controller;

import com.blocky.backend.dto.ProjectDetailResponse;
import com.blocky.backend.dto.ProjectSummaryResponse;
import com.blocky.backend.dto.SaveResponse;
import com.blocky.backend.dto.request.ProjectCreateRequest;
import com.blocky.backend.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {

    private final ProjectService projectService;

    // GET /api/projects
    // GET /api/projects?userId=1
    @GetMapping
    public List<ProjectSummaryResponse> list(@RequestParam(required = false) Integer userId) {
        if (userId == null) {
            return projectService.listProjects();
        }
        return projectService.listProjectsByUser(userId);
    }

    // POST /api/projects
    @PostMapping
    public SaveResponse create(@Valid @RequestBody ProjectCreateRequest req) {
        return projectService.createProject(req);
    }

    // GET /api/projects/{projectId}
    @GetMapping("/{projectId}")
    public ProjectDetailResponse get(@PathVariable Long projectId) {
        return projectService.getProject(projectId);
    }
}
