package com.capgemini.sort;

import java.util.Scanner;

public class CorrectnessLoopInvariant {

	public static void insertionSort(int[] A) {

		int n = A.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (A[j - 1] > A[j]) {
					// swap elements
					temp = A[j - 1];
					A[j - 1] = A[j];
					A[j] = temp;
				}

			}
		}

		printArray(A);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		insertionSort(ar);
	}
}
