package com.capgemini.thirtydayscode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Day29BitWise {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<Integer> inputn = new ArrayList<Integer>();
		List<Integer> inputk = new ArrayList<Integer>();

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			inputn.add(n);
			inputk.add(k);

		}

		Iterator itrn = inputn.iterator();
		Iterator itrk = inputk.iterator();

		while (itrn.hasNext() && itrk.hasNext()) {
			Object nn = itrn.next();
			Object kk = itrk.next();

			int n = (int) nn;
			int k = (int) kk;
			// store values in an array
			int[] N = new int[n];
			for (int i = 0; i < n; i++) {
				N[i] = i + 1;
			}
			int max = 0;
			// loop through array and locate the bitwise operator less than n.
			for (int j = 0; j < n; j++) {
				for (int m = j + 1; m < n; m++) {
					int bitwise = N[j] & N[m];
					// System.out.println("The "+ N[j] + " & " + N[m]+ " are: " + bitwise);
					if (bitwise < k && bitwise > max) {
						max = bitwise;
					}
				}
			}

			System.out.println(max);

		}

		scanner.close();

	}

}
