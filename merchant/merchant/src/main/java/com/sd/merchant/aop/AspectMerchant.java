package com.sd.merchant.aop;

import com.sd.merchant.Exception.InvalidMerchantDataException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectMerchant {
    @AfterThrowing(pointcut = "execution(* com.sd.merchant.service.MerchantServiceImpl.findByMerchantAcNo(..))", throwing = "e")
    public void execute(InvalidMerchantDataException e)
    {
        System.out.println("Exception Occured: " + e.getMessage());
    }
}
