package com.capgemini.strings;

import java.util.Scanner;

public class StringEvenOdd {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		// Accept string input N times.
		for (int j = 0; j < N; j++) {
			System.out.println("Enter a String value: ");
			String s = scanner.nextLine();
			String even = "";
			String odd = "";

			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0)
					even += String.valueOf(s.charAt(i));
				else
					odd += String.valueOf(s.charAt(i));
			}

			System.out.println("Enter the numbers");
		}

	}

}
