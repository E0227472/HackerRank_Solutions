package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArraysLeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		// final array to return
		int b [];
		// getting the left hand rotation elements first 
		b = Arrays.copyOfRange(a, d, a.length);
		List<Integer> arrListb = new ArrayList<Integer>();
		// converting the array to arraylist 
		arrListb = Arrays.stream(b).boxed().collect(Collectors.toList());
		
		for(int i = 0; i < d; i++) {
			arrListb.add(a[i]);
		}
		
		b  = arrListb.stream().mapToInt(i -> i).toArray();
		
		return b;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of array and left rotation number respectively: ");
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];
		
		System.out.println("Enter the elements for the array: ");
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(a, d);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}

		scanner.close();
	}
}
