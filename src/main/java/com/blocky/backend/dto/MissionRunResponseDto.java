package com.blocky.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MissionRunResponseDto {
    private Integer userId;
    private Integer missionId;
    private String htmlCode;
    private String blockJson;
    private LocalDateTime savedAt;
    private String status;            // POST 시 "success", GET 시 null
    private LocalDateTime submittedAt; // POST 시 값 있음, GET 시 null
}
