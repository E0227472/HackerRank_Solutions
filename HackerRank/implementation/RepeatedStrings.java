package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedStrings {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long stringRepeats = n / (s.length());
		long frequency = 0;
		long frequenceBalance = 0;
		// number of a's in one string
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				frequency++;
		}

		long wholeRepeatsas = frequency * stringRepeats; // => total number of a's in whole string repeats
		long balanceChars = n % (s.length());
		String balanceSubString = s.substring(0, (int) balanceChars);

		// number of a's in balanceSubString
		for (int i = 0; i < balanceSubString.length(); i++) {
			if (balanceSubString.charAt(i) == 'a')
				frequenceBalance++;
		}

		long totalRepeats = frequenceBalance + wholeRepeatsas;
		return totalRepeats;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a string value: ");
		String s = scanner.nextLine();
		System.out.println("Enter the length of the substring: ");
		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(String.valueOf(result));
		scanner.close();
	}

}
