// src/main/java/com/blocky/backend/dto/request/ProjectCreateRequest.java
package com.blocky.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectCreateRequest(
        @NotNull Integer userId,
        @NotBlank String title,
        @NotBlank String htmlCode,
        @NotBlank String blockJson
) {}
