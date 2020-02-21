package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumDistances {

	// Complete the minimumDistances function below.
	static int minimumDistances(int[] a) {
		List<Integer> minDifference = new ArrayList<Integer>();

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					int diff = j - i;
					minDifference.add(diff);
				}
			}
		}

		if (minDifference.size() == 0)
			return -1;
		else {
			int min = Collections.min(minDifference);

			return min;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of the array: ");

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		System.out.println("Enter the array elements: ");
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int result = minimumDistances(a);

		System.out.println(String.valueOf(result));
		scanner.close();
	}

}
