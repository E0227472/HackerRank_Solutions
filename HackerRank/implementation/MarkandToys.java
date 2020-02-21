package com.capgemini.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MarkandToys {

	// Complete the maximumToys function below.
	static int maximumToys(int[] prices, int k) {
		// sort array.
		// Loop through array.
		// get the sum and count of elements until it equals or exceeds sum.
		Arrays.sort(prices);
		int sum = 0;
		int count = 0;
		for (int ele : prices) {
			sum += ele;
			if (sum == k) {
				count++;
				break;
			} else if (sum > k)
				break;
			else if(sum < k)
				count++;
		}

		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("enter the size of array and the sum respectively: ");

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] prices = new int[n];

		System.out.println("Enter the array elements: ");
		String[] pricesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pricesItem = Integer.parseInt(pricesItems[i]);
			prices[i] = pricesItem;
		}

		int result = maximumToys(prices, k);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
