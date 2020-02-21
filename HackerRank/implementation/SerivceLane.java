package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SerivceLane {

	// cases: rows and columns of starting and ending index respectively.
	// width: array with all the different widths
	// n: array length
	static int[] serviceLane(int n, int[][] cases, int[] width) {
		int[] result;
		List<Integer> results = new ArrayList<Integer>();
		int[] temparray;
		
		

		for (int i = 0; i < cases.length; i++) { // => rows
			temparray = Arrays.copyOfRange(width, cases[i][0], cases[i][1]+1);
//			for(int aa: temparray)
//				System.out.print(aa + " ");
			List<Integer> temparrayList = Arrays.stream(temparray).boxed().collect(Collectors.toList());
			int min = Collections.min(temparrayList);
			results.add(min);
			//System.out.println();
		}
		
		result = results.stream().mapToInt(i -> i).toArray();
		
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println(" Enter the size of array and the number of test cases:  ");
		String[] nt = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nt[0]);

		int t = Integer.parseInt(nt[1]);

		int[] width = new int[n];

		System.out.println("Enter the array elements ");
		String[] widthItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int widthItem = Integer.parseInt(widthItems[i]);
			width[i] = widthItem;
		}

		int[][] cases = new int[t][2];
		System.out.println("Enter the test cases: ");
		for (int i = 0; i < t; i++) {
			String[] casesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int casesItem = Integer.parseInt(casesRowItems[j]);
				cases[i][j] = casesItem;
			}
		}

		int[] result = serviceLane(n, cases, width);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}

		scanner.close();
	}
}
