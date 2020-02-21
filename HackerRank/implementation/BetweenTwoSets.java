package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BetweenTwoSets {

	/*
	 * Complete the getTotalX function below.
	 */
	static int getTotalX(int[] a, int[] b) {
		List<Integer> factors = new ArrayList<Integer>();
		// sort both arrays to find the smallest value in a and biggest value in b.
		Arrays.sort(a);
		Arrays.sort(b);
		int counta = 0;
		int countb = 0;
		// first loop is to find the integer
		for (int i = a[0]; i <= b[b.length - 1]; i++) {
			// loop through first array to find if the elements are all factors of given
			// integer
			for (int elea : a) {
				if (i % elea == 0) {
					counta++;
					// System.out.println("The element a is : " + elea + " with integer " + i);
				} else
					break;
			}
			// if first array all factors of given integer, check if that number is a factor
			// for second array.
			if (counta == a.length) {
				for (int eleb : b) {
					if (eleb % i == 0) {
						countb++;
//						System.out.println("The element b is: " + eleb);
//						System.out.println("The integer is: " + i);
					} else
						break;
				}
			}

			if (counta == a.length && countb == b.length) {
				factors.add(i);
			}

			counta = 0;
			countb = 0;
		}

//		for (int aa : factors)
//			System.out.println("The integers are: " + aa);
		
		return factors.size();

	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Print the size of the 2 arrays respectively: ");
		String[] nm = scan.nextLine().split(" ");

		int n = Integer.parseInt(nm[0].trim());

		int m = Integer.parseInt(nm[1].trim());

		int[] a = new int[n];
		System.out.println("Enter elements for the first array: ");
		String[] aItems = scan.nextLine().split(" ");

		for (int aItr = 0; aItr < n; aItr++) {
			int aItem = Integer.parseInt(aItems[aItr].trim());
			a[aItr] = aItem;
		}

		int[] b = new int[m];
		System.out.println("Enter elements for the second array: ");
		String[] bItems = scan.nextLine().split(" ");

		for (int bItr = 0; bItr < m; bItr++) {
			int bItem = Integer.parseInt(bItems[bItr].trim());
			b[bItr] = bItem;
		}

		int total = getTotalX(a, b);

		System.out.println(String.valueOf(total));
		scan.close();
	}

}
