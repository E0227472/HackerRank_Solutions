package com.capgemini.strings;

import java.util.Scanner;

public class SeperateNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = scanner.nextLine();
		int n = s.length();
		int difference = 0;
		int count = 0;
		int count9s = 0;
		int countNumbers = 1;

		// determine if there are any 9s in the string
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '9')
				count9s++;
		}

		// if the length of the string is even or length is odd and no 9's.
		if (n % 2 == 0 || (n % 2 != 0 && count9s == 0)) {
			// outer loop of n / i.
			for (int i = 1; i < n; i++) {
				if (n % i == 0) { // => if the number is divisible by string length, there are n/i (i digits)
					// loop through whole string to find the i digit substrings.
					count = 0;
					for (int j = 0; j < n; j += i) {
						if ((j + i) < n && (j + i + i) <= n) { // => the substrings should be lesser than string length.
							String s1 = s.substring(j, j + i);
							String s2 = s.substring(j + i, j + i + i);
							difference = Integer.parseInt(s2) - Integer.parseInt(s1);
							if (difference == 1 && s1.charAt(0) != '0' && s2.charAt(0) != '0')
								count++; // => count should match i-1
							else
								break; // => if difference not 1, break.

						} else
							break;
					}
					int numberCount = n / i;
					int numMatch = numberCount - 1;
					if (numMatch == count)
						break;
					else
						count = 0;
				}
			}

			// if the length of the string is odd and there are 9's in the string
		} else if (n % 2 != 0 && count9s != 0) {
		
			for (int i = 1; i < n; i++) {
				String s1 = null;
				String s2 = null;
				for (int j = 0; j < s.length(); j += i) { // => increment by k to get the substring

					if ((j + i) < s.length() && (j + i + i) <= s.length()) {
						 s1 = s.substring(j, j + i);

						if (s1.charAt(s1.length() - 1) == '9') { // => if the last digit has number 9.
							// get the next number to see if there is a difference by 1
							s2 = s.substring(j + i, j + i + i + 1);
							difference = Integer.parseInt(s2) - Integer.parseInt(s1);

							if (difference == 1 && s1.charAt(0) != '0' && s2.charAt(0) != '0') {
								// getting new substring with increased number of digits
								s = s.substring(j + i);
								count++;
								countNumbers++;
								break;
							} else // => if the difference is not 1, break loop
								break;
						} else { // => if the last digit is not 9
							s2 = s.substring(j + i, j + i + i);
							difference = Integer.parseInt(s2) - Integer.parseInt(s1);

							if (difference == 1 && s1.charAt(0) != '0' && s2.charAt(0) != '0') {
								count++;
								countNumbers++;
							} else // => if the difference is not 1
								break;
						}
					}
				}
				System.out.println("The quantity of numbers are: " + countNumbers);
				System.out.println("The number of differences are: " + count);
				int match = countNumbers - 1;
				if (count == match && count !=0)
					break;
				else {
					count = 0;
					countNumbers = 1;
				}

			}
		}
		if (count != 0)
			System.out.println("Beautiful strings");
		else
			System.out.println("Not beautiful strings");
	}
}
