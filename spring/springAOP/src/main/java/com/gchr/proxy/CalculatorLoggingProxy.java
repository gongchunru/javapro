package com.gchr.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLoggingProxy {
	
	private ICalculator target;
	
	public CalculatorLoggingProxy(ICalculator target) {
		super();
		this.target = target;
	}
	
	public ICalculator getLogProxy(){
		ICalculator proxy = null;
		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = new Class[]{ICalculator.class};
		InvocationHandler handler  = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodName = method.getName();
				System.out.println("[before] The method"+methodName+" begin with "+Arrays.asList(args));
				Object result = null;
				try {
					result = method.invoke(target, args);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println("[after] The method ends with"+result);
				return result;
			}
		};
		proxy = (ICalculator)Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
	
}
