package com.sd.merchant.Exception;

public class InvalidMobNumException extends RuntimeException{

    public InvalidMobNumException(String errorMsg)
    {
        super(errorMsg);
    }
}
