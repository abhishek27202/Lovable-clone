package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.Subscription.PlanLimitResponse;
import com.coding.lovable_clone.dto.Subscription.UsageTodayResponse;
import com.coding.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitofUser(Long userId) {
        return null;
    }

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }
}
