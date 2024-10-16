package com.sd.merchant.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidApiException extends RuntimeException{


    public InvalidApiException(String errorMessage)
    {
        super(errorMessage);
    }

}
