package com.zero.springframework.aspect.common.aspect;

import com.zero.springframework.aspect.common.util.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class TaskAspect {


    @Pointcut("execution(* com.zero.springframework.aspect.service..*.*(..))")
    public void aopPoint() {}

    @Pointcut(value = "@annotation(com.zero.springframework.aspect.common.annotation.TaskAnnotation)")
    public void pointcut() {}

    @Before("aopPoint()")
    public void doBefore(JoinPoint point) throws Throwable {
        log.info("before ....");
    }

    @After("aopPoint()")
    public void doAfter(JoinPoint point) throws Throwable {
        log.info("after ....");
    }

    @Around("pointcut()")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Method currentMethod = AspectUtil.getMethod(point);
        long starttime = System.currentTimeMillis();
        Object result = point.proceed();
        long endtime = System.currentTimeMillis();
        long requesttime = endtime - starttime;
        //if(requesttime>1000){
        log.info(AspectUtil.getClassName(point) + "." + currentMethod.getName() + "execute time：" + requesttime + " ms");
        //}
        return result;
    }

}
