package com.coding.lovable_clone.controller;


import com.coding.lovable_clone.dto.Subscription.PlanLimitResponse;
import com.coding.lovable_clone.dto.Subscription.UsageTodayResponse;
import com.coding.lovable_clone.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UsageController {

    private final UsageService usageService;

    @GetMapping()
    public ResponseEntity<UsageTodayResponse>getTodayUsage(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));

    }
    @GetMapping("/")
    public ResponseEntity<PlanLimitResponse> getPlansLimit(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitofUser(userId));
    }
}
