package com.sd.merchant.aop;

import com.sd.merchant.Exception.InvalidMobNumException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectValidate {
    String mobNum = null;
    @Before("execution(* com.sd.merchant.service.MerchantServiceImpl.getNameAndEmail(..))")
    public void bValidate(JoinPoint joinPoint) {
        mobNum = (String) joinPoint.getArgs()[0];
        System.out.println("Stored mobNo: " + mobNum);
        if (mobNum.length() > 10) {
            throw new InvalidMobNumException("Error Message: InvalidMobNumException: please add valid Mobile number");

        }

    }
    @After("execution(* com.sd.merchant.service.MerchantServiceImpl.getNameAndEmail(..))")
    public void aValidate()
    {
        System.out.println("Mobile number is valid ");
    }
}
