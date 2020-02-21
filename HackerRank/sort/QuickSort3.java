package com.capgemini.sort;

import java.util.Scanner;

public class QuickSort3 {
	
	private static int count = 0;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = input.nextInt();
		}
		
		quicksort(ar, 0, ar.length - 1);
		
		System.out.println("The count is: " + count);
	}
	// algorithm works recursively. For e.g., taking the l.h.s sorting example, 
	// the pivot's index will be -1 over one cycle and checks will be done to ensure the 
	// values on the left hand side are always lesser. otherwise swapping will happen. 
	// this concept applies to the right, but +1.
	static void quicksort(int[] array, int beg, int end) {
		if(beg >= end) return;
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
		//printArray(array);

		// Sort left of partition
		quicksort(array, beg, wall - 1);

		// Sort right of partition
		quicksort(array, wall + 1, end);
	}

	static void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
		count++;
	}

	static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println("");
	}
}
