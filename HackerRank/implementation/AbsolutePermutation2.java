package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbsolutePermutation2 {

	// Complete the absolutePermutation function below.
	static int[] absolutePermutation(int n, int k) {
		List<Integer> sumArray = new ArrayList<Integer>();
		int sum[] = new int[n];
		// If k is 0 then we just print the
		// permutation from 1 to n
		if (k==0) {
			for (int i = 0; i < n; ++i)
				sumArray.add(i+1);
			sum = sumArray.stream().mapToInt(i -> i).toArray();
		}

		// Check whether permutation is
		// feasible or not
		else if (n % (2 * k) != 0) {
			sum = new int [1];
			sum[0] = -1;

		}else {
			for (int i = 0; i < n; ++i) {
				// Put i + k + 1 candidate
				// if position is feasible,
				// otherwise put the
				// i - k - 1 candidate
				if ((i / k) % 2 == 0)
					sumArray.add(i+k+1);
				else
					sumArray.add(i - k + 1);
			}
			
			sum =  sumArray.stream().mapToInt(i -> i).toArray();
		}

		return sum;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		// System.out.println("Enter the value for n and k: ");
		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			int[] result = absolutePermutation(n, k);

			for (int i = 0; i < result.length; i++) {
				System.out.println(String.valueOf(result[i]));

				if (i != result.length - 1) {
					System.out.println(" ");
				}
			}
		}
		scanner.close();
	}

}
