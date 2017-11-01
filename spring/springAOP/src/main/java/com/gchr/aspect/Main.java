package com.gchr.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext-aop.xml");
//		ICalculator calc = ctx.getBean(ICalculator.class);
		
		Calc calc = ctx.getBean(Calc.class);
		
		int result = calc.add(2, 1);
		System.out.println("the result"+result);
	}
}
