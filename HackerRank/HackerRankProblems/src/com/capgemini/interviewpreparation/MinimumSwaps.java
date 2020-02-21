package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int i = 0;
		int count = 0;
		while (i < arr.length) {
			int currentValue = i + 1;
			if (arr[i] != currentValue) {
				for (int j = 0; j < arr.length; j++) {
					if ((currentValue == arr[j])) {
						// swap temp and arr[i]
	                    int temp = arr[j];
	                    arr[j] = arr[i];
	                    arr[i] = temp;
	                    count++;
	                    break;	
					}
				}
				i++;
			} else {
				i++;
				continue;
			}
		}
		
		return count;
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

		int res = minimumSwaps(arr);

		System.out.println(String.valueOf(res));

		scanner.close();
	}

}
