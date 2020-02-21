package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class ChocolateFeast {

	// Complete the chocolateFeast function below.
	static int chocolateFeast(int n, int c, int m) {
		// number of initial bars and wrappers
		int barQuantity = n / c;
		int sumWrappers = barQuantity;
		int remainderWrappers = sumWrappers;

		while (remainderWrappers >= m) {
			int bars = remainderWrappers / m;
			remainderWrappers = (remainderWrappers % m) + bars;

			sumWrappers += bars;
		}

		return sumWrappers;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter the number of test cases: ");
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		System.out.println("Enter the values for n, c and m: ");
		for (int tItr = 0; tItr < t; tItr++) {
			String[] ncm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(ncm[0]);

			int c = Integer.parseInt(ncm[1]);

			int m = Integer.parseInt(ncm[2]);

			int result = chocolateFeast(n, c, m);

			System.out.println(String.valueOf(result));

		}
		scanner.close();
	}

}
