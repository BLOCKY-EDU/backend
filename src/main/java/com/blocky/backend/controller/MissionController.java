package com.blocky.backend.controller;

import com.blocky.backend.dto.MissionDto;
import com.blocky.backend.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public List<MissionDto> getMissions(@RequestParam(required = false) String level) {
        if (level != null) {
            return missionService.getMissionsByLevel(level);
        } else {
            return missionService.getAllMissions();
        }
    }

    @GetMapping("/{id}")
    public MissionDto getMissionById(@PathVariable Integer id) {
        return missionService.getMissionById(id);
    }
}
