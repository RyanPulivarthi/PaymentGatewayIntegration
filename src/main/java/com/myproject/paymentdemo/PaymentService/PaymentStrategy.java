package com.myproject.paymentdemo.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentStrategy {
    @Autowired
    RazorypayUrl razorypayUrl;
    @Autowired
    StripeUrl stripeUrl;
    public String getUrl(Long id,Long amount){
        String paymentLink;
        Random random=new Random();
        int rando=random.nextInt(1000);
        if(rando%2==0) paymentLink= razorypayUrl.generateUrl(id,amount);
        else paymentLink=stripeUrl.generateUrl(id,amount);
        return paymentLink;
    }
}
