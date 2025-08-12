package com.blocky.backend.controller;

import com.blocky.backend.dto.MissionRunRequestDto;
import com.blocky.backend.dto.MissionRunResponseDto;
import com.blocky.backend.service.MissionRunService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mission-run")
@RequiredArgsConstructor
public class MissionRunController {

    private final MissionRunService missionRunService;

    @GetMapping("/{userId}/{missionId}")
    public MissionRunResponseDto getMissionRun(
            @PathVariable Integer userId,
            @PathVariable Integer missionId
    ) {
        return missionRunService.getMissionRun(userId, missionId);
    }

    @PostMapping
    public MissionRunResponseDto saveMissionRun(@RequestBody MissionRunRequestDto requestDto) {
        return missionRunService.saveMissionRun(requestDto);
    }
}
