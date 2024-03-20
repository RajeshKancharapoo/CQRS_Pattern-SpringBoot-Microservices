package com.example.queryservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class ServiceLoggingAspect {

    @Around("execution(* com.example.queryservice.service.*.*(..))")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Entering {}.{}", className, methodName);
        Object result = joinPoint.proceed();
        log.info("Exiting {}.{}", className, methodName);
        return result;
    }
}
