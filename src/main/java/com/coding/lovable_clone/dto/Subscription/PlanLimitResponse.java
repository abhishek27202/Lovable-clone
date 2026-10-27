package com.coding.lovable_clone.dto.Subscription;

public record PlanLimitResponse(
        String planName,
        int maxTokenPerDay,
        int maxProjects,
        boolean UnlimitedAi
) {
}
