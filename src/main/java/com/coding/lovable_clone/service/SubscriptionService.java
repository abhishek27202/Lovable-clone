package com.coding.lovable_clone.service;

import com.coding.lovable_clone.dto.Subscription.CheckOutRequest;
import com.coding.lovable_clone.dto.Subscription.CheckOutResponse;
import com.coding.lovable_clone.dto.Subscription.PortalResponse;
import com.coding.lovable_clone.dto.Subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {

     SubscriptionResponse getCurrentubscription(Long userId);

     PortalResponse openCustomerPortal(Long userId);

     CheckOutResponse createCheckoutResponse(CheckOutRequest request, Long userId);
}
