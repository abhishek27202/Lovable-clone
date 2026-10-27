package com.coding.lovable_clone.service;

import com.coding.lovable_clone.dto.Subscription.PlanLimitResponse;
import com.coding.lovable_clone.dto.Subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
     PlanLimitResponse getCurrentSubscriptionLimitofUser(Long userId);

     UsageTodayResponse getTodayUsageOfUser(Long userId);
}
