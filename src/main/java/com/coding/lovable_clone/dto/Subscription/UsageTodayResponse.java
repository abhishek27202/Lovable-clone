package com.coding.lovable_clone.dto.Subscription;

public record UsageTodayResponse(
        int tokenUsed,
        int tokenLimit,
        int previewsRunning,
        int previewsLimit
) {
}
