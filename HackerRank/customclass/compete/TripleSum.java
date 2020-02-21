package com.capgemini.compete;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TripleSum {

	// Complete the triplets function below.
	static long triplets(int[] a, int[] b, int[] c) {

		int[] arr = Arrays.stream(a).sorted().distinct().toArray();
		int[] brr = Arrays.stream(b).sorted().distinct().toArray();
		int[] crr = Arrays.stream(c).sorted().distinct().toArray();

		long countTotal = 0;
		int counta = 0;
		int countc = 0;

		for(int numb: brr) {
			// stream gets numbers that are greater than or equals to the element in the
			// first array.

			while(counta < arr.length && arr[counta] <= numb) 
				counta++;

			while(countc < crr.length && crr[countc] <= numb) 
				countc++;
			//System.out.println("The count for " + numb + " " + "counta: " + counta + " countc: " + countc);
				countTotal += (counta * countc);

	}

		return countTotal;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the array lengths of a, b and c respectively: ");
		String[] lenaLenbLenc = scanner.nextLine().split(" ");

		int lena = Integer.parseInt(lenaLenbLenc[0]);

		int lenb = Integer.parseInt(lenaLenbLenc[1]);

		int lenc = Integer.parseInt(lenaLenbLenc[2]);

		System.out.println("Enter the array elements for a, b and c respectively in different lines: ");
		int[] arra = new int[lena];

		String[] arraItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lena; i++) {
			int arraItem = Integer.parseInt(arraItems[i]);
			arra[i] = arraItem;
		}

		int[] arrb = new int[lenb];

		String[] arrbItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenb; i++) {
			int arrbItem = Integer.parseInt(arrbItems[i]);
			arrb[i] = arrbItem;
		}

		int[] arrc = new int[lenc];

		String[] arrcItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < lenc; i++) {
			int arrcItem = Integer.parseInt(arrcItems[i]);
			arrc[i] = arrcItem;
		}

		long ans = triplets(arra, arrb, arrc);

		System.out.println(String.valueOf(ans));

		scanner.close();
	}

}
