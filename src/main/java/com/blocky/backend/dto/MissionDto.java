package com.blocky.backend.dto;

import com.blocky.backend.entity.Mission.Level;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionDto {
    private Integer missionId;
    private String title;
    private String description;
    private Level level;
}
