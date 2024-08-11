package org.example.paymentservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto extends Exception{
    public ExceptionDto(String message){
        super(message);
    }
}
