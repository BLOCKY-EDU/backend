package com.blocky.backend.dto;

import java.time.LocalDate;

public record ProjectDetailResponse(
        Long projectId,
        Long userId,
        String title,
        String htmlCode,
        String blockJson,
        LocalDate createdAt
) {}
