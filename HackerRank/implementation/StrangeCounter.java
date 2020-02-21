package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class StrangeCounter {

	// Complete the strangeCounter function below.
	static long strangeCounter(long t) {
//		long i = 1;
//		long value = 3;
//		long originalValue = 3;
//		long finalValue = 0;
//		while (i <= t) {
//			if (i == t)
//				finalValue = value;
//			i++;
//			value--;
//			if (value == 1) {
//				originalValue = originalValue * 2;
//				value = originalValue;
//				++i;
//			}
//
//		}
		
		int n = 0;
		long totalTime = 0;
		
		while( t > totalTime) {
			long lengthBlock = 3 * (long)Math.pow(2, n);
			totalTime += lengthBlock;
			n++;
		}
		
		long difference = totalTime - t;
		
		long value = difference+1;
		
		return value;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the time to check the value for:  ");

		long t = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = strangeCounter(t);

		System.out.println("The value is: " + result);
		scanner.close();
	}

}
