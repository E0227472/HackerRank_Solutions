package com.capgemini.DBS;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Problem3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get the value for N, the number of strings to enter 
		System.out.println("Enter value for N: ");
		int N = Integer.parseInt(sc.next());
		//store the string values into an array
		String [] numberInput = new String[N];
		System.out.println("Enter the String values: ");
		for(int i=0; i < numberInput.length; i++) {
			numberInput[i] = sc.next();
		}
		//Take only 12 digits each string and store into an array
		long [] convertNumbers = new long[N];
		for(int i=0; i < convertNumbers.length; i++) {
			convertNumbers[i] = Long.parseLong(numberInput[i].substring(0,12));
		}
		// getting sum of all elements 
		long totalSum = LongStream.of(convertNumbers).sum();
		
		// convert sum of all elements to String
		String totalSumString = Long.toString(totalSum);
		
		// get first 10 digits of String
		
		String totalSumTen = totalSumString.substring(0,10);
		
		System.out.println(totalSumTen);
	}

}
