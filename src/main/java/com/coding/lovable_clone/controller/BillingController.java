package com.coding.lovable_clone.controller;

import com.coding.lovable_clone.dto.Subscription.*;
import com.coding.lovable_clone.service.PlanService;
import com.coding.lovable_clone.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class BillingController {
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>>getAllPlans(){
        return ResponseEntity.ok(planService.getAllActivePlan());
    }
    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId=1L;
        return  ResponseEntity.ok(subscriptionService.getCurrentubscription(userId));
    }
    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckOutResponse> createCheckoutResponse(
            @RequestBody CheckOutRequest request
    ){
        Long userId=1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutResponse(request,userId));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(){
        Long userId=1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));

    }
}
