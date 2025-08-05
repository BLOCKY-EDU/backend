package com.blocky.backend.controller;

import com.blocky.backend.dto.MissionExampleDto;
import com.blocky.backend.service.MissionExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mission")
public class MissionExampleController {

    private final MissionExampleService missionExampleService;

    @GetMapping("/{missionId}/example")
    public MissionExampleDto getMissionExample(@PathVariable Integer missionId) {
        return missionExampleService.getExampleByMissionId(missionId);
    }
}
