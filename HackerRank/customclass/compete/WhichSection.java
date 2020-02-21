package com.capgemini.compete;

import java.io.IOException;
import java.util.Scanner;

public class WhichSection {

	// Complete the whichSection function below.
	static int whichSection(int n, int k, int[] a) {

		int prevSectionMax = 0;
		int sectionMax = 0;
		int section = 0;
		for (int i = 0; i < a.length; i++) {
			sectionMax += a[i];
			if(k > prevSectionMax && k <= sectionMax) {
				section = i +1;
				break;
			}
		}
		
		return section;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		System.out.println("Enter values for n, k and m: ");
		for (int tItr = 0; tItr < t; tItr++) {
			String[] nkm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nkm[0]);

			int k = Integer.parseInt(nkm[1]);

			int m = Integer.parseInt(nkm[2]);

			int[] a = new int[m];

			System.out.println("Enter the values for the array: ");
			String[] aItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < m; i++) {
				int aItem = Integer.parseInt(aItems[i]);
				a[i] = aItem;
			}

			int result = whichSection(n, k, a);

			System.out.println(String.valueOf(result));

		}

		scanner.close();
	}

}
