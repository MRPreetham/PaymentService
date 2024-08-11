package org.example.paymentservice.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CreatePaymentLinkResponseDto {
    private String paymentLink;
}
