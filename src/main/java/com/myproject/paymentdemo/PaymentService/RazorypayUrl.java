package com.myproject.paymentdemo.PaymentService;

import org.springframework.stereotype.Component;

@Component
public class RazorypayUrl implements PaymentServiceInterface {
    @Override
    public String generateUrl(Long id,Long amount){

        //try {
            /*RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", true);
            paymentLinkRequest.put("first_min_partial_amount", 100);
            paymentLinkRequest.put("expire_by", 1691097057);
            paymentLinkRequest.put("reference_id", "TS1989");
            paymentLinkRequest.put("description", "Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name", "+919000090000");
            customer.put("contact", "Gaurav Kumar");
            customer.put("email", "gaurav.kumar@example.com");
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
            JSONObject notes = new JSONObject();
            notes.put("policy_name", "Jeevan Bima");
            paymentLinkRequest.put("notes", notes);
            paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url").toString();*/
            return "https://rzp.io/i/nxrHnLJ";

        /*}catch (RazorpayException e){
            throw new RuntimeException(e);
        }
*/
    }
}
