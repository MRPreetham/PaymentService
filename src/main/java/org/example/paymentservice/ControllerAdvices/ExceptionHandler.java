package org.example.paymentservice.ControllerAdvices;

import com.razorpay.RazorpayException;
import org.example.paymentservice.Dtos.ExceptionDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(RazorpayException.class)
    public ResponseEntity<ExceptionDto> InvalidPaymentDetailsException(RazorpayException e){
        ExceptionDto dto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(dto,
                HttpStatusCode.valueOf(402));
    }
}
