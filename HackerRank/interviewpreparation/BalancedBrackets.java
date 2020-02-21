package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Scanner;

public class BalancedBrackets {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);

			System.out.println(result);
		}

		scanner.close();
	}

}
