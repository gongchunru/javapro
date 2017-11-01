package com.gchr.proxy2;

public class Main {

	public static void main(String[] args) {
		Calc calc = new Calc();
		calc = new CalcLogProxy2(calc).getLogProxy();
		calc.add(1, 2);
//		short a = 1;
//		short b = 1;
//		System.out.println(a!=b);
	}
	
	
	

}
