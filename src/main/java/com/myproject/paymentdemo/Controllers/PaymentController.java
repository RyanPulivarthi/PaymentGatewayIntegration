package com.myproject.paymentdemo.Controllers;

import com.myproject.paymentdemo.DTOs.CrreatePaymentDTO;
import com.myproject.paymentdemo.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/makePayment")
    public String initiatePayment(@RequestBody CrreatePaymentDTO crreatePaymentDTO){
        String str=paymentService.generateURL(crreatePaymentDTO.getId(),crreatePaymentDTO.getAmount());
        return str;
    }
}
