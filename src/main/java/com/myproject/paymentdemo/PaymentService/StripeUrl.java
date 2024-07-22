package com.myproject.paymentdemo.PaymentService;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.springframework.http.RequestEntity.post;
@Component
public class StripeUrl implements PaymentServiceInterface {
    @Value("${stripe.key}")
    private String key;
    @Override
    public String generateUrl(Long id, Long amount) {
        Stripe.apiKey = key;
        try {
            SessionCreateParams params =
                    SessionCreateParams.builder()
                            .addLineItem(
                                    SessionCreateParams.LineItem.builder()
                                            .setPriceData(
                                                    SessionCreateParams.LineItem.PriceData.builder()
                                                            .setCurrency("usd")
                                                            .setProductData(
                                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                            .setName("T-shirt")
                                                                            .build()
                                                            )
                                                            .setUnitAmount(amount)
                                                            .build()
                                            )
                                            .setQuantity(1L)
                                            .build()
                            )
                            .setMode(SessionCreateParams.Mode.PAYMENT)
                            .setSuccessUrl("http://gmail.com")
                            .setCancelUrl("http://localhost:4242/cancel.html")
                            .build();

            Session session = Session.create(params);
            return session.getUrl();
        }catch (StripeException e){
            throw new RuntimeException(e);
        }
    }
}
