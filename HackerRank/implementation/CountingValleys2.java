package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys2 {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int previoussum = 0;
		int cumulativeSum = 0;
		int value = 0;
		int countValley = 0;
		char[] chars = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {

			if (chars[i] == 'D') {
				value = -1;
				cumulativeSum += value;
				System.out.println("the cumulative sum is: " + cumulativeSum);

			} else if (chars[i] == 'U') {
				value = 1;
				cumulativeSum += value;
				System.out.println("the cumulative sum is: " + cumulativeSum);
			}
			
			if(cumulativeSum <0 && previoussum == 0) {
				countValley++;
			}
			
			previoussum = cumulativeSum;

		}

		return countValley;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of steps Gary takes: ");

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Enter the string value: ");
		String s = scanner.nextLine();
		int result = countingValleys(n, s);
		System.out.println(String.valueOf(result));
		scanner.close();
	}

}
