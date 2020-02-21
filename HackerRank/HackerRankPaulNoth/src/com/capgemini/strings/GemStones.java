package com.capgemini.strings;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GemStones {

	// Complete the gemstones function below.
	static int gemstones(String[] arr) {
		Map<Character, Integer> countChar = new TreeMap<Character, Integer>();
		Set<Character> s = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			// remove repetitions in the String
			for (int j = 0; j < arr[i].length(); j++) {
				s.add(arr[i].charAt(j));
			}
			for (Character a : s) {
				if (!countChar.containsKey(a)) {
					countChar.put(a, 1);
				} else {
					countChar.put(a, countChar.get(a) + 1);
				}
			}

			s.clear();
		}
		int count = 0;
		for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
			if (entry.getValue() == arr.length) {
				count++;
			}
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter the size of the array: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arr = new String[n];

		System.out.println("Enter the Strings: ");
		for (int i = 0; i < n; i++) {
			String arrItem = scanner.nextLine();
			arr[i] = arrItem;
		}

		int result = gemstones(arr);
		System.out.println("The number of gemstones are: " + result);
	}
}
