package com.capgemini.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MissingNumbers {

	// arr longer array, brr shorter arrays
	static int[] missingNumbers(int[] arr, int[] brr) {
		int[] missingNums;
		Arrays.sort(arr);
		Arrays.sort(brr);

		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> brrList = Arrays.stream(brr).boxed().collect(Collectors.toList());

		List<Integer> arrListOriginal = Arrays.stream(arr).boxed().collect(Collectors.toList());
//		if (arr.length > brr.length) {
			// removes every occurance of elements (finding completely missing numbers)
			arrList.removeAll(brrList);
			// completely missing numbers exist
			if (arrList.size() != 0) {
				List<Integer> missingNumsList = new ArrayList<Integer>();
				Set<Integer> arrSet = new TreeSet(arrList);
				for (int x : arrSet)
					missingNumsList.add(x);
				
				for(int aaa: missingNumsList)
				 System.out.println("the missing numbers are: " + aaa);

				// removes all the completely missing numbers from list. now duplicate and
				// original set same.
				arrListOriginal.removeAll(missingNumsList);
				// hashmap to store the frequency of element of original
				Map<Integer, Integer> om = new TreeMap<Integer, Integer>();
				// count the number of original elements
				for (int k : arrListOriginal) {
					Integer j = om.get(k);
					om.put(k, (j == null) ? 1 : j + 1);
				}

				// hashmap to store the frequency of element duplicate
				Map<Integer, Integer> dm = new TreeMap<Integer, Integer>();
				// count the number of original elements
				for (int k : brrList) {
					Integer j = dm.get(k);
					dm.put(k, (j == null) ? 1 : j + 1);
				}
				

				// displaying the occurrence of elements in the arraylist
				for (Map.Entry<Integer, Integer> val : om.entrySet()) {
					int key = val.getKey();
					int value = val.getValue();
					int duplicateKeyValue = dm.get(key);

					if (value != duplicateKeyValue) {
						missingNumsList.add(key);
					}
				}
				
				missingNums = missingNumsList.stream().mapToInt(l -> l).toArray();
				Arrays.sort(missingNums);
				
				return missingNums;

			} else {
				List<Integer> frequencyChange = new ArrayList<Integer>();
				// hashmap to store the frequency of element of original
				Map<Integer, Integer> om = new TreeMap<Integer, Integer>();
				// count the number of original elements
				for (int k : arrListOriginal) {
					Integer j = om.get(k);
					om.put(k, (j == null) ? 1 : j + 1);
				}

				// hashmap to store the frequency of element duplicate
				Map<Integer, Integer> dm = new TreeMap<Integer, Integer>();
				// count the number of original elements
				for (int k : brrList) {
					Integer j = dm.get(k);
					dm.put(k, (j == null) ? 1 : j + 1);
				}

				// displaying the occurrence of elements in the arraylist
				for (Map.Entry<Integer, Integer> val : om.entrySet()) {
					int key = val.getKey();
					int value = val.getValue();
					int duplicateKeyValue = dm.get(key);

					if (value != duplicateKeyValue) {
						frequencyChange.add(key);
					}
				}
				
				missingNums = frequencyChange.stream().mapToInt(i -> i).toArray();
				
				Arrays.sort(missingNums);
				
				return missingNums;

			}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of first array: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] brr = new int[n];
		System.out.println("Enter first array elements: ");
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			brr[i] = arrItem;
		}
		System.out.println("Enter size of second array: ");
		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[m];
		System.out.println("Enter second array elements: ");
		String[] brrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int brrItem = Integer.parseInt(brrItems[i]);
			arr[i] = brrItem;
		}

		int[] result = missingNumbers(arr, brr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}

		scanner.close();
	}

}
