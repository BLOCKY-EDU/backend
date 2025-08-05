package com.blocky.backend.service;

import com.blocky.backend.dto.MissionExampleDto;
import com.blocky.backend.entity.Mission;
import com.blocky.backend.entity.MissionExample;
import com.blocky.backend.repository.MissionExampleRepository;
import com.blocky.backend.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionExampleService {

    private final MissionRepository missionRepository;
    private final MissionExampleRepository missionExampleRepository;

    public MissionExampleDto getExampleByMissionId(Integer missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 미션이 존재하지 않습니다."));

        MissionExample example = missionExampleRepository.findByMission(mission)
                .orElseThrow(() -> new IllegalArgumentException("해당 미션의 예시가 존재하지 않습니다."));

        return new MissionExampleDto(example.getHtmlCode(), example.getBlockJson());
    }
}