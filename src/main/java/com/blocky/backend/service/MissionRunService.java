package com.blocky.backend.service;

import com.blocky.backend.dto.MissionRunRequestDto;
import com.blocky.backend.dto.MissionRunResponseDto;
import com.blocky.backend.entity.Mission;
import com.blocky.backend.entity.MissionRun;
import com.blocky.backend.entity.User;
import com.blocky.backend.repository.MissionRepository;
import com.blocky.backend.repository.MissionRunRepository;
import com.blocky.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MissionRunService {

    private final MissionRunRepository missionRunRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    // GET
    public MissionRunResponseDto getMissionRun(Integer userId, Integer missionId) {
        MissionRun missionRun = missionRunRepository.findByUser_UserIdAndMission_MissionId(userId, missionId)
                .orElseThrow(() -> new IllegalArgumentException("MissionRun not found"));

        return MissionRunResponseDto.builder()
                .userId(missionRun.getUser().getUserId())
                .missionId(missionRun.getMission().getMissionId())
                .htmlCode(missionRun.getHtmlCode())
                .blockJson(missionRun.getBlockJson())
                .savedAt(missionRun.getSavedAt())
                .build();
    }

    // POST
    public MissionRunResponseDto saveMissionRun(MissionRunRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Mission mission = missionRepository.findById(requestDto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        MissionRun missionRun = missionRunRepository.findByUser_UserIdAndMission_MissionId(
                        requestDto.getUserId(), requestDto.getMissionId())
                .orElse(new MissionRun());

        missionRun.setUser(user);
        missionRun.setMission(mission);
        missionRun.setHtmlCode(requestDto.getHtmlCode());
        missionRun.setBlockJson(requestDto.getBlockJson());
        missionRun.setSavedAt(LocalDateTime.now());
        missionRun.setSubmittedAt(LocalDateTime.now());

        missionRunRepository.save(missionRun);

        return MissionRunResponseDto.builder()
                .userId(missionRun.getUser().getUserId())
                .missionId(missionRun.getMission().getMissionId())
                .htmlCode(missionRun.getHtmlCode())
                .blockJson(missionRun.getBlockJson())
                .savedAt(missionRun.getSavedAt())
                .status("success")
                .submittedAt(missionRun.getSubmittedAt())
                .build();
    }
}
