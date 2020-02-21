package com.capgemini.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CountSort {

	// Complete the countingSort function below.
	// values in arr are stored as indexes in count array. count the index.
	static int[] countingSort(int[] arr) {
		// get max value in array
		int max = Arrays.stream(arr).max().getAsInt();
		
		System.out.println(max);

		// array of 0's at indices 0...maxValue
		int numCounts[] = new int[100];

		// populate numCounts
		for (int num : arr) {
			numCounts[num]++;
		}

//		// populate the final sorted array
//		int[] sortedArray = new int[arr.length];
//		int currentSortedIndex = 0;
//
//		// for each num in numCounts
//		for (int num = 0; num < numCounts.length; num++) {
//			int count = numCounts[num];
//
//			// for the number of times the item occurs
//			for (int i = 0; i < count; i++) {
//
//				// add it to the sorted array
//				sortedArray[currentSortedIndex] = num;
//				currentSortedIndex++;
//			}
//		}

		return numCounts;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] result = countingSort(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");

//			if (i != result.length - 1) {
//				System.out.println("");
//			}
		}

		scanner.close();
	}

}
