package org.example.paymentservice.Services;

import com.razorpay.RazorpayException;
import org.json.JSONObject;

public interface PaymentService {
    JSONObject CreatPaymentLink(String oderId) throws RazorpayException;
    String getPaymentStatus(String status);
}
