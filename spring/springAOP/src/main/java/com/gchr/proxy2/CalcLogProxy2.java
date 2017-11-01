package com.gchr.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalcLogProxy2 {
	private Calc target;
	
	public CalcLogProxy2(Calc target) {
		super();
		this.target=target;
	}
	
	public Calc getLogProxy(){
		Calc proxy = null;
		ClassLoader classLoader = target.getClass().getClassLoader();
		Class[] classes = new Class[]{target.getClass()};
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodName = method.getName();
				System.out.println("begin "+methodName+"参数"+args);
				Object result = null;
				result = method.invoke(target, args);
				System.out.println(result);
				return result;
			}
		};
		proxy = (Calc)Proxy.newProxyInstance(classLoader, classes, h);
		return proxy;
	}
}
