package org.example.paymentservice.Controllers;

import com.razorpay.RazorpayException;
import org.example.paymentservice.Dtos.CreatePaymentLinkRequestDto;
import org.example.paymentservice.Dtos.CreatePaymentLinkResponseDto;
import org.example.paymentservice.Services.PaymentService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    private CreatePaymentLinkRequestDto requestDto;
    private CreatePaymentLinkResponseDto responseDto;

    public PaymentController(PaymentService paymentService,
                             CreatePaymentLinkRequestDto requestDto,
                             CreatePaymentLinkResponseDto responseDto){
        this.paymentService = paymentService;
        this.requestDto = requestDto;
        this.responseDto = responseDto;
    }
    @PostMapping("")
    public CreatePaymentLinkResponseDto createPaymentLink(
            @RequestBody CreatePaymentLinkRequestDto requestDto)
            throws RazorpayException {
        JSONObject paymentLink =  paymentService.CreatPaymentLink(requestDto.getOrderId());
        responseDto.setPaymentLink(paymentLink.get("short_url").toString());
        return responseDto;
    }

    @PostMapping("/webHook")
    public JSONObject webHook(@RequestBody JSONObject jsonObject){
        return jsonObject;
    }
}
