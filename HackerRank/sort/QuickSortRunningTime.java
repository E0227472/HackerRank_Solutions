package com.capgemini.sort;

import java.util.Scanner;

public class QuickSortRunningTime {

	private static int countQuickSort = 0;
	//private static int countInsertionSort = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = input.nextInt();
		}

		quicksort(ar, 0, ar.length - 1);
		 insertionSort(ar);

		System.out.println("The count for quicksort is: " + countQuickSort);
		//System.out.println("The count for insertionsort is: " + countInsertion);

	}

	// algorithm works recursively. For e.g., taking the l.h.s sorting example,
	// the pivot's index will be -1 over one cycle and checks will be done to ensure
	// the
	// values on the left hand side are always lesser. otherwise swapping will
	// happen.
	// this concept applies to the right, but +1.
	static void quicksort(int[] array, int beg, int end) {
		if (beg >= end)
			return;
		// last element is the pivot
		int pivot = array[end];
		int wall = beg;

		// Partition with a wall
		for (int i = beg; i < end; i++) {
			if (array[i] < pivot) {
				swap(array, i, wall);
				wall++;
			}
		}

		// Place pivot
		swap(array, end, wall);

		// Print after partition
		// printArray(array);

		// Sort left of partition
		quicksort(array, beg, wall - 1);

		// Sort right of partition
		quicksort(array, wall + 1, end);
	}

	// Complete the insertionSort1 function below.
	public static void insertionSort(int[] A) {
		int count = 3;
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) {
				A[j + 1] = A[j];
				j = j - 1;
				count++;
			}
			A[j + 1] = value;
			//count += i - (j + 1);
		}
		
		System.out.println(count);
	}

	static void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
		countQuickSort++;
	}

	static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println("");
	}

}
