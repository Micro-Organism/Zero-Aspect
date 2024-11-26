package com.zero.springframework.aspect.common.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


public class AspectUtil {

	public static String getClassName(ProceedingJoinPoint point) {
		return point.getTarget().getClass().getName().replaceAll("\\.", "_");
	}

	public static Method getMethod(ProceedingJoinPoint point) throws NoSuchMethodException {
		Signature sig = point.getSignature();
		MethodSignature msig = (MethodSignature) sig;
		Object target = point.getTarget();
		return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
	}

}
