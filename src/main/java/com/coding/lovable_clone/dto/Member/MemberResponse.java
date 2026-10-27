package com.coding.lovable_clone.dto.Member;

import com.coding.lovable_clone.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant InvitedAt
) {

}
