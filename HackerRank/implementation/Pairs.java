package com.capgemini.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		// sort the array
		// for each element, add by k.
		// find arr[i] + k. if found, count++.
		// copy to a new array within range and find using binary search.

		Arrays.sort(arr);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i] + k;
			if (i < arr.length - 1) {
				int index = Arrays.binarySearch(arr, sum);
				if(index >= 0)
					count++;
			} else
				break;

		}
		
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the array size and difference respectively: ");
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];
		System.out.println("Enter the array elements: ");
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = pairs(k, arr);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
