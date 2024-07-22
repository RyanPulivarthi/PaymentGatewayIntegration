package com.myproject.paymentdemo.Services;

import com.myproject.paymentdemo.PaymentService.PaymentServiceInterface;
import com.myproject.paymentdemo.PaymentService.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentStrategy paymentStrategy;
    public String generateURL(Long id,Long amount){
        return paymentStrategy.getUrl(id,amount);
    }
}
