package com.capgemini.DBS;

public class Problem1 {

	public static void main(String[] args) {
	
		int a = 2;
		int b = 3;
		System.out.println("Before Swapping numbers: a is "+ a+ ", b is " + b );
		// a is now 5
		a = a+b;
		// 5 - 3 = 2, b is now a
		b = a-b;
		// 5 - 2 = 3, a is now b
		a = a -b;
		System.out.println("After Swapping numbers: a is "+ a+ ", b is " + b );
		
		
	}

}
