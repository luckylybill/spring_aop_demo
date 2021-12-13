package com.jerry.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * created by jerry on 2021-12-12
 */
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.jerry.service.impl.*.*(..))")
    public void PointCut() {

    }

    @Before("PointCut()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知，执行方法" + signature.getName() + "参数是：" + Arrays.asList(args));
    }

    @After("PointCut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("后置通知，执行方法" + signature.getName() + "参数是：" + Arrays.asList(args));
    }

    @AfterThrowing(value = "PointCut()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("异常通知，发生异常：" + ex.getMessage());
    }

    @AfterReturning(value = "PointCut()", returning = "returnVal")
    public void afterReturning(Object returnVal) {
        System.out.println("返回通知,返回值是" + returnVal.toString());
    }
}
