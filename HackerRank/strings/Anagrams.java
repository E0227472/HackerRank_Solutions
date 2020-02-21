package com.capgemini.strings;

import java.io.IOException;
import java.util.Scanner;

public class Anagrams {

	// Complete the anagram function below.
	static int anagram(String s) {
		int result = 0;
		int count = 0;
		if (s.length() % 2 != 0)
			result = -1;
		else {

			String s1 = s.substring(0, s.length() / 2);
			String s2 = s.substring(s.length() / 2);
			String s1Sorted = s1.chars().sorted()
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
			String s2Sorted = s2.chars().sorted()
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
			for (int i = 0; i < s1Sorted.length(); i++) {
				// maximum limit of s2. length is variable. get the index.
				int lengths2Sorted = s2Sorted.length() - 1;
				// need to sort from back from front. condition is while greater than 0.
				while (lengths2Sorted >= 0) {
					// if character match
					if (s1Sorted.charAt(i) == s2Sorted.charAt(lengths2Sorted)) {
						// not last index since will have array out of bounds
						if (s2Sorted.length() - 1 != lengths2Sorted) {
							s2Sorted = s2Sorted.substring(0, lengths2Sorted) + s2Sorted.substring(lengths2Sorted + 1);
							count++;
							break;
							// if happen to match at last index
						} else {
							s2Sorted = s2Sorted.substring(0, lengths2Sorted);
							count++;
							break;
						}
					} else {
						lengths2Sorted--;
					}
				}

			}
			result = s2.length() - count;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter a String value: ");
		String s = scanner.nextLine();
		int result = anagram(s);
		System.out.println(s + " is a anagram: " + result);
	}

}
