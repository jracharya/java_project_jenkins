package com.sd.merchant.Exception;

import com.sd.merchant.Exception.InvalidApiException;
import com.sd.merchant.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(InvalidApiException.class)
//    public ResponseEntity<ErrorMessage> handleInvalidApiException(InvalidApiException e) {
//        ErrorMessage errorMessage = new ErrorMessage(101, e.getMessage());
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(InvalidMobNumException.class)
    public ResponseEntity<?> invalidMobileNum(InvalidMobNumException exception)
    {
        ErrorMessage errorMessage = new ErrorMessage(102, exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
