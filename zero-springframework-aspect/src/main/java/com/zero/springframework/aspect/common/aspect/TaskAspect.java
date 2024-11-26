package com.zero.springframework.aspect.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TaskAspect {


    @Pointcut("execution(* com.zero.springframework.aspect.service..*.*(..))")
    public void aopPoint() {

    }

    @Before("aopPoint()")
    public void doBefore(JoinPoint point) throws Throwable {
        log.info("before ....");
    }

    @After("aopPoint()")
    public void doAfter(JoinPoint point) throws Throwable {
        log.info("after ....");
    }
}
