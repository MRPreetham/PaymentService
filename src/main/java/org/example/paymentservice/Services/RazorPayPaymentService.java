package org.example.paymentservice.Services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorPayPaymentService implements PaymentService{
    private RazorpayClient razorpayClient;

    public RazorPayPaymentService(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }
    @Override
    public JSONObject CreatPaymentLink(String oderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis()+10*60*1000);
        paymentLinkRequest.put("reference_id",oderId);
        paymentLinkRequest.put("description","Payment for order_id "+ oderId);

        JSONObject customer = new JSONObject();
        customer.put("name","Preetham");
        customer.put("contact","9742109918");
        customer.put("email","ppreetham156@gmail.com");
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name","Spring Boot");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://localhost/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toJson();
    }

    @Override
    public String getPaymentStatus(String status) {
        return null;
    }
}
