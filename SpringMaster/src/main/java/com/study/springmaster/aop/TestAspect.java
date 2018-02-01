package com.study.springmaster.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class TestAspect {

	@Before("execution(String com.study.springmaster.controller.*.*(..))")
	public void doSomethingBefore(JoinPoint joinPoint) {
		System.out.println("before!!");
	}

	@After("execution(String com.study.springmaster.controller.*.*(..))")
	public void doSomethingAfter(JoinPoint joinPoint) {
		System.out.println("AFTER!!");
	}

/*	@AfterReturning(pointcut = "execution(String com.study.springmaster.controller.*.*(..))", returning = "result")
	public void doSomethingAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println(result.toString());
		System.out.println(joinPoint.toString());
	}*/

	@Pointcut("@within(com.study.springmaster.controller.*)")
	public void doSomethingPointCut(JoinPoint joinPoint) {

		System.out.println("pointCut!!");
		System.out.println(joinPoint.toString());
	}

	@Around("execution(String com.study.springmaster.controller.*.*(..))")
    public void coverAround(ProceedingJoinPoint joinPoint) {
        try {
            // 해당 메소드 호출
	        	System.out.println("aroundBefore");
            joinPoint.proceed();
            System.out.println("aroundAfter");
        } catch (Throwable e) {
        }
    }
}
