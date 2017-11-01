package com.gchr.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public int com.gcr.aspect.Calc.add(int, int))")
	public void beforeMethod(){
		System.out.println("The method before");
	}
}

