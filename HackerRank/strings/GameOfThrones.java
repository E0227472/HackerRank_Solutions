package com.capgemini.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GameOfThrones {

	// Complete the gameOfThrones function below.
	static String gameOfThrones(String s) {
		String result = null;
		// if string has even length
		if (s.length() % 2 == 0) {
			Map<Character, Integer> numChars = new HashMap<Character, Integer>();
			Set<Character> uniqueChars = new HashSet<Character>();
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				char charAt = s.charAt(i);
				uniqueChars.add(charAt);
				if (!numChars.containsKey(charAt))
					numChars.put(charAt, 1);
				else
					numChars.put(charAt, numChars.get(charAt) + 1);
			}

			for (Integer j : numChars.values()) {
				if (j % 2 == 0)
					count++;
			}
			if (count == uniqueChars.size()) {
				result = "YES";
			} else {
				result = "NO";
			}
		} else { // => if string has odd length
			Map<Character, Integer> numChars = new HashMap<Character, Integer>();
			Set<Character> uniqueChars = new HashSet<Character>();
			for (int i = 0; i < s.length(); i++) {
				uniqueChars.add(s.charAt(i));
			}
			if (uniqueChars.size() == 1)
				result = "YES";
			else if (uniqueChars.size() == 2)
				result = "YES";
			else if (uniqueChars.size() > 2) {
				int count = 0;
				for (int i = 0; i < s.length(); i++) {
					char charAt = s.charAt(i);
					if (!numChars.containsKey(charAt))
						numChars.put(charAt, 1);
					else
						numChars.put(charAt, numChars.get(charAt) + 1);
				}
				for (Integer j : numChars.values()) {
					if (j % 2 == 0)
						count++;
				}

				if (uniqueChars.size() % 2 == 0 && count % 2 != 0 && count !=0)
					result = "YES";
				else if (uniqueChars.size() % 2 != 0 && count % 2 == 0 && count !=0)
					result = "YES";
				else
					result = "NO";

			}
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter a String: ");
		String s = scanner.nextLine();

		String result = gameOfThrones(s);
		System.out.println(s + " is a palindrome: " + result);
	}

}
