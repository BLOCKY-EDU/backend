package com.blocky.backend.dto;

import java.time.LocalDate;

public record ProjectSummaryResponse(
        Long projectId,
        String title,
        LocalDate createdAt
) {}
