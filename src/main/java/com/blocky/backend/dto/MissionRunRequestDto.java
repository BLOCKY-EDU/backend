package com.blocky.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MissionRunRequestDto {
    private Integer userId;
    private Integer missionId;
    private String htmlCode;
    private String blockJson;
}
