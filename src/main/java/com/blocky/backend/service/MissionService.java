package com.blocky.backend.service;

import com.blocky.backend.dto.MissionDto;
import com.blocky.backend.entity.Mission;
import com.blocky.backend.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionDto> getAllMissions() {
        return missionRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<MissionDto> getMissionsByLevel(String levelStr) {
        try {
            Mission.Level level = Mission.Level.valueOf(levelStr); // "초급" -> Level.초급
            return missionRepository.findByLevel(level).stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("잘못된 레벨 값입니다: " + levelStr);
        }
    }

    public MissionDto getMissionById(Integer id) {
        return missionRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("미션을 찾을 수 없습니다."));
    }

    private MissionDto convertToDto(Mission mission) {
        return MissionDto.builder()
                .missionId(mission.getMissionId())
                .title(mission.getTitle())
                .description(mission.getDescription())
                .level(mission.getLevel())
                .build();
    }
}
