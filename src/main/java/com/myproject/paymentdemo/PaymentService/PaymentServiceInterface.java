package com.myproject.paymentdemo.PaymentService;

import org.springframework.stereotype.Component;

@Component
public interface PaymentServiceInterface {
    public String generateUrl(Long id,Long amount);
}
