package com.capgemini.practise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		int countAnagramPairs = 0;
		Map<String, Integer> countsubStrings = new HashMap<String, Integer>();

		// Find all combinations of substrings
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {

				String subString = s.substring(i, j);
				
				char subStringchars[] = subString.toCharArray();
				Arrays.sort(subStringchars);
				subString = String.valueOf(subStringchars);
				
				countsubStrings.put(subString,
						(!countsubStrings.containsKey(subString)) ? 1 : countsubStrings.get(subString) + 1);
				System.out.println(subString);
			}
		}

		// loop through the map to find for substrings with count more than 2.
		for (Map.Entry<String, Integer> val : countsubStrings.entrySet()) {
			int value = val.getValue();
			int numerator = 1;
			int denominator = 1;
			for(int i = 1; i <= value; i++) {
				numerator *= i;
			}

			for(int i = 1; i <= value-2; i++) {
				denominator *= i;
			}
			
			int combinations = (numerator) / (denominator * 2);
			countAnagramPairs += combinations;
		}

		return countAnagramPairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Enter the Strings: ");
		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			System.out.println(String.valueOf(result));
		}

		scanner.close();
	}
}
