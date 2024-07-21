package com.myproject.paymentdemo.PaymentStrategy;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import static org.springframework.http.RequestEntity.post;

public class StripeUrl implements PaymentStrategy{
    @Override
    public String generateUrl(Long id, Long amount) {
        Stripe.apiKey = "sk_test_51PewDJ2MWpRDtiO0FEGSGUB4ISzLdGyRQYwil8FDGLfhN8dnhhc95QdIiAhnbznpmLJ0H6gkMUetHkarLzy5vFkN00CZp1MIkn";

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
                        .setSuccessUrl("http://localhost:4242/success.html")
                        .setCancelUrl("http://localhost:4242/cancel.html")
                        .build();

        Session session = Session.create(params);
        return session.getUrl();
    }
}
