package com.coding.lovable_clone.dto.project;

import com.coding.lovable_clone.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
