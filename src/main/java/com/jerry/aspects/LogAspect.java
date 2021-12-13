package com.jerry.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.jerry.service.impl.UserServiceImpl.*(..))")
    public void getCut(){

    }

    @Before("getCut()")
    public static void before(JoinPoint joinPoint) {
        Signature method = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println(method.getName()+"方法运行后，参数是"+(args==null?"": Arrays.asList(args).toString()));
    }
    @After("getCut()")
    public static void after(JoinPoint joinPoint) {
        Signature method = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println(method.getName()+"方法运行后，参数是"+(args==null?"": Arrays.asList(args).toString()));
    }
    @AfterThrowing(value="getCut()",throwing = "ex")
    public static void afterException(Exception ex) {
        System.out.println("方法运行出现异常:"+ex.getMessage());
    }
    @AfterReturning(value="getCut()",returning = "returnValue")
    public static void afterEnd(Object returnValue) {
        System.out.println("方法结束，返回值是："+returnValue);
    }
}
