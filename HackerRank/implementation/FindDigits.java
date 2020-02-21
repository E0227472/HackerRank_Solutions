package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class FindDigits {

	// Complete the findDigits function below.
	static int findDigits(int n) {
		String number = String.valueOf(n);
		char [] charn = number.toCharArray();
		int countDivisor = 0;
		
		for(int i = 0; i < charn.length; i++) {
			if(Integer.parseInt(String.valueOf(charn[i])) == 0)
				continue;
			else if( n % Integer.parseInt(String.valueOf(charn[i])) == 0) {
				countDivisor++;
			}
			
		}
		
		return countDivisor;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		System.out.println("Enter the integer to be analyzed: ");
		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int result = findDigits(n);

			System.out.println(String.valueOf(result));
		}
		scanner.close();
	}

}
