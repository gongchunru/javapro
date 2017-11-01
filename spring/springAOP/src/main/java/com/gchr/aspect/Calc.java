package com.gchr.aspect;

import org.springframework.stereotype.Component;

//看来这个注解不区分大小写。
@Component("Calc")
public class Calc {
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}
	
	public int div(int i, int j) {
		int result = i / j;
		return result;
	}
}
