package com.gchr.proxy;

public class Main {

	public static void main(String[] args) {
		ICalculator iCalculator = new CalculatorImpl();
		iCalculator = new CalculatorLoggingProxy(iCalculator).getLogProxy();

		int result = iCalculator.add(1, 2);
		
	}

}
