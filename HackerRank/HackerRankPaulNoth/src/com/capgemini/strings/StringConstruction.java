package com.capgemini.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringConstruction {

	// Complete the stringConstruction function below.
	static int stringConstruction(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Boolean> charMap = new HashMap<>();
		for (int i = 0; i < chars.length; i++) {
			charMap.put(chars[i], true);
		}
		return charMap.size();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a String value: ");
		String s = scanner.nextLine();
		int result = stringConstruction(s);
		System.out.println("Total cost is= " + result);
	}
}
