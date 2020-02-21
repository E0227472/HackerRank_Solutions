package com.capgemini.sort;

import java.util.Scanner;

public class InsertionSorting {

	// Complete the insertionSort1 function below.
	static void insertionSort1(int n, int[] arr) {

		int original[] = new int[n];
		original = arr;

		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			if (arr[j] > key) {
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					if (j == 0 && arr[j] > key) {
						arr[j] = key;
					}
					j = j - 1;
				}

				arr[j + 1] = key;
				for (int a : arr) {
					System.out.print(a + " ");
				}
				System.out.println("");
			} else {
				for (int a : arr) {
					System.out.print(a + " ");
				}
				System.out.println("");
			}
				
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		insertionSort1(n, arr);

		scanner.close();

	}

}
