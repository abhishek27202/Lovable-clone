package com.coding.lovable_clone.serviceImpl;

import com.coding.lovable_clone.dto.Subscription.CheckOutRequest;
import com.coding.lovable_clone.dto.Subscription.CheckOutResponse;
import com.coding.lovable_clone.dto.Subscription.PortalResponse;
import com.coding.lovable_clone.dto.Subscription.SubscriptionResponse;
import com.coding.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentubscription(Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }

    @Override
    public CheckOutResponse createCheckoutResponse(CheckOutRequest request, Long userId) {
        return null;
    }
}
