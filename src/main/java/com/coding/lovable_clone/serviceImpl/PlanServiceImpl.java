package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.Subscription.PlanResponse;
import com.coding.lovable_clone.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlan() {
        return List.of();
    }
}
