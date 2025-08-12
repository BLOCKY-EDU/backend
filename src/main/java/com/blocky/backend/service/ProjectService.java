package com.blocky.backend.service;

import com.blocky.backend.dto.ProjectDetailResponse;
import com.blocky.backend.dto.ProjectSummaryResponse;
import com.blocky.backend.dto.SaveResponse;
import com.blocky.backend.dto.request.ProjectCreateRequest;
import com.blocky.backend.entity.Project;
import com.blocky.backend.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<ProjectSummaryResponse> listProjects() {
        return projectRepository.findAllSummaries();
    }

    @Transactional(readOnly = true)
    public List<ProjectSummaryResponse> listProjectsByUser(Integer userId) {
        return projectRepository.findSummariesByUserId(userId);
    }

    public SaveResponse createProject(ProjectCreateRequest req) {
        Project p = Project.builder()
                .userId(req.userId())
                .title(req.title())
                .htmlCode(req.htmlCode())
                .blockJson(req.blockJson())
                .build();
        Project saved = projectRepository.save(p);
        return new SaveResponse(saved.getProjectId(), "저장 완료");
    }

    @Transactional(readOnly = true)
    public ProjectDetailResponse getProject(Long projectId) {
        Project p = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("프로젝트가 존재하지 않습니다: " + projectId));
        return new ProjectDetailResponse(
                p.getProjectId(),
                p.getUserId().longValue(), // 필요하면 Long 변환
                p.getTitle(),
                p.getHtmlCode(),
                p.getBlockJson(),
                p.getCreatedAt()
        );
    }
}
