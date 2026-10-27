package com.coding.lovable_clone.service;

import com.coding.lovable_clone.dto.Subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {
     List<PlanResponse> getAllActivePlan();
}
