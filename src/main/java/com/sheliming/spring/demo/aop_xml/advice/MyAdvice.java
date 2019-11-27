package com.sheliming.spring.demo.aop_xml.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 编写通知类
 * @author think
 *
 */
@Aspect
public class MyAdvice {
	
	//演示前置通知
	@Before(value = "execution(* *..*.*.*(..))")
	public void log() {
		System.out.println("开始记录日志了...");
	}
	
}
