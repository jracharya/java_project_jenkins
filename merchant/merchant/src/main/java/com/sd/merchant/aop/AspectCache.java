package com.sd.merchant.aop;
import com.sd.merchant.model.Merchant;
import com.sd.merchant.util.CacheUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectCache {

    @Autowired
    CacheUtil cacheUtil;

    @Around("execution(* com.sd.merchant.service.MerchantServiceImpl.getDataByMobNo(..))")
    public Merchant execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Merchant merchant = null;

        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String mobNum = (String) proceedingJoinPoint.getArgs()[0];

        System.out.println("Class name= "+className);
        System.out.println("Method name= "+methodName);
        System.out.println("Parameter= "+mobNum);

        if (cacheUtil.isKeyPresent(mobNum)) {
            merchant = cacheUtil.fetchData(mobNum);
            System.out.println("data retrieved from cache");
        } else {
            merchant = (Merchant) proceedingJoinPoint.proceed();
            cacheUtil.storeData(mobNum, merchant);
            System.out.println("Connected to database and fetch the data");
        }
        return merchant;
    }

}
