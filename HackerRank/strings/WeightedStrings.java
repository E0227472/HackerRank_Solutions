package com.capgemini.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class WeightedStrings {

	// Complete the weightedUniformStrings function below.
	static String[] weightedUniformStrings(String s, int[] queries) {
		// to store cumulative sum
		ArrayList<Integer> cumSum = new ArrayList<Integer>();

		int count = 0;
		int sum = 0;
		// sorting String s alphabetically
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		String sorteds = new String(chars);
		// loop through the string
		while (sorteds.length() > 0) {
			char c = sorteds.charAt(0);
			System.out.println("The character is: " + c);
			int weightc = (c - 'a') + 1;
			// looping through String again to find the number of char c in the sorted
			// String
			for (int j = 0; j < sorteds.length(); j++) {
				if (sorteds.charAt(j) == c)
					count++;
			}

			// getting the cumulative sum of the characters and comparing with weighted sum
			for (int k = 0; k < count; k++) {
				sum += weightc;
				System.out.println("The sum of " + c + "is " + sum);
				// store the sums in an ArrayList. To convert to array later.
				cumSum.add(sum);
			}
			System.out.println("The length of String with " + c + " as first character: " + sorteds.length());
			System.out.println("The count of " + c + " is: " + count);

			if (count != sorteds.length()) {
				sorteds = sorteds.substring(count);
				count = 0;
				sum = 0;
			} else
				break;
		}
		String[] resultArray = new String[queries.length];
		// converting ArrayList to array
		int[] sumArray = new int[cumSum.size()];
		for (int i = 0; i < sumArray.length; i++) {
			sumArray[i] = cumSum.get(i).intValue();
		}

		for (int i = 0; i < queries.length; i++) {
			int index = i;
			boolean contains = IntStream.of(sumArray).anyMatch(x -> x == queries[index]);
			if (contains)
				resultArray[i] = "Yes";
			else
				resultArray[i] = "No";
		}

		return resultArray;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a String value: ");
		String s = scanner.nextLine();
		System.out.println("Enter int array size: ");
		int queriesCount = Integer.parseInt(scanner.nextLine());
		int[] queries = new int[queriesCount];

		System.out.println("Enter the array elements: ");
		for (int i = 0; i < queries.length; i++) {
			queries[i] = Integer.parseInt(scanner.nextLine());
		}

		String[] result = weightedUniformStrings(s, queries);

		for (String a : result) {
			System.out.println("The String results are: " + a);
		}
	}

}
