package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Scanner;

public class MaxSumArray {

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {

		int inclPrevCurrentSumMax = arr[0];
		int exclCurrentSumMax = 0;
		int inclCurrentSumMax = 0;
		for (int i = 1; i < arr.length; i++) {
			inclCurrentSumMax = exclCurrentSumMax + arr[i];
			//System.out.println("The inclCurrentSumMax is : " + inclCurrentSumMax);
			exclCurrentSumMax = Math.max(inclPrevCurrentSumMax, exclCurrentSumMax);
			//System.out.println("The exclCurrentSumMax is : " + exclCurrentSumMax);
			// getting the maximum previous sum of previous excl and include
			inclPrevCurrentSumMax = inclCurrentSumMax;
		}

		return Math.max(inclCurrentSumMax, exclCurrentSumMax);
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

		int res = maxSubsetSum(arr);

		System.out.println(String.valueOf(res));

		scanner.close();

	}
}
