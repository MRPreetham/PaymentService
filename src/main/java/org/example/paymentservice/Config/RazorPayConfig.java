package org.example.paymentservice.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    @Value("${razorpay.key.id}")
    private String razorpayKey;
    @Value("${razorpay.key.secret}")
    private String razorpaySecret;
    @Bean
    public RazorpayClient razorpayClient() throws RazorpayException {
        return new RazorpayClient(
                razorpayKey,
                razorpaySecret
        );
    }
}