package com.capgemini.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IceCreamParlour {

	// Complete the icecreamParlor function below.
	static int[] icecreamParlor(int m, int[] arr) {
		int firstIndex = 0;
		int secondIndex = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int a = arr[i];
				int b = arr[j];
				
				if((a+b) == m) {
					firstIndex = i;
					secondIndex = j;
					break;
				}
			}
		}
		int [] sum = new int[2];
		sum[0] = firstIndex+1;
		sum[1] = secondIndex+1;
		
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// number of test cases
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			// sum to be compared with
			int m = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			// array size
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			// array elements
			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}
			// returning index of the 2 elements sum.
			int[] result = icecreamParlor(m, arr);

			for (int i = 0; i < result.length; i++) {
				System.out.println(String.valueOf(result[i]));

				if (i != result.length - 1) {
					System.out.println(" ");
				}
			}
		}
		scanner.close();
	}

}
