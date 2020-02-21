package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		// strings => the array to be searched
		// queries => the array's elements that are to be searched
		List<Integer> countItems = new ArrayList<Integer>();
		Map<String, Integer> countFrequency = new HashMap<String, Integer>();
		for (String ele : strings) {
			countFrequency.put(ele, (!countFrequency.containsKey(ele)) ? 1 : countFrequency.get(ele) + 1);
		}
		
		for(String q : queries) {
			if(countFrequency.containsKey(q))
				countItems.add(countFrequency.get(q));
			else 
				countItems.add(0);
		}
		
		int result[] = countItems.stream().mapToInt(i -> i).toArray();
		
		return result;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of input array: ");

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];
		System.out.println("Enter the input array elements: ");
		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}
		System.out.println("Enter the size of query array: ");
		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];
		System.out.println("Enter the query array elements: ");
		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		int[] res = matchingStrings(strings, queries);

		for (int i = 0; i < res.length; i++) {
			System.out.println(String.valueOf(res[i]));

			if (i != res.length - 1) {
				System.out.println("\n");
			}
		}

		scanner.close();
	}

}
