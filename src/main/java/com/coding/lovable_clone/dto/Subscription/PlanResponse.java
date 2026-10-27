package com.coding.lovable_clone.dto.Subscription;

public record PlanResponse(  Long id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Integer maxPreviews,
        Boolean unlimitedAi,
        Boolean active) {
}
