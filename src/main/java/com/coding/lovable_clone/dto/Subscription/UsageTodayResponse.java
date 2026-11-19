package com.coding.lovable_clone.dto.Subscription;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer tokenLimit,
        Integer previewsRunning,
        Integer previewsLimit
) {
}
