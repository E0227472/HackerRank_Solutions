package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EqualizeArray {

	// Complete the equalizeArray function below.
	static int equalizeArray(int[] arr) {
		List<Integer> arrListOccurance = new ArrayList<Integer>();

		// hashmap to calcuate the frequence of each element in the array
		Map<Integer, Integer> arrayElements = new TreeMap<Integer, Integer>();
		// arr elements are the key.
		for (int k : arr) {
			arrayElements.put(k, (!arrayElements.containsKey(k)) ? 1 : arrayElements.get(k) + 1);
		}

		// adding the frequency of each elements to arraylist
		for (Map.Entry<Integer, Integer> val : arrayElements.entrySet()) {
			int value = val.getValue();
			System.out.println("The frequencies of " + val.getKey() + " are: " + value);
			arrListOccurance.add(value);
		}

		int max = Collections.max(arrListOccurance);

		if (max == 1) {
			int sum = 0;
			for (int a : arrListOccurance)
				sum += a;
			
			sum -= 1;
			return sum;
		} else {
			arrListOccurance.remove(new Integer(max));

			int sum = 0;
			for (int a : arrListOccurance)
				sum += a;
			return sum;
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of the array: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		System.out.println("Enter the array elements: ");
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = equalizeArray(arr);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
