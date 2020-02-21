package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AbsolutePermutation {

	// Complete the absolutePermutation function below.
	static int[] absolutePermutation(int n, int k) {
		int value = 0;
		List<Integer> sumArray = new ArrayList<Integer>();
		for (int i = n - 1; i >= 0; i--) { // => looping through each index to find sum
			int index = i + 1;
			int sum = index + k;
			System.out.println("The index is: " + sum);
			if (sum <= n && sum > 0 && !sumArray.contains(sum)) {
				sumArray.add(sum);
			} else if (sum > n || sumArray.contains(sum)) {
				int sumAlternative = Math.abs(k - index);
				if (sumAlternative > 0 && sumAlternative <= n && !sumArray.contains(sumAlternative))
					sumArray.add(sumAlternative);
				else {
					value = -1;
					break;
				}
			} else {
				value = -1;
				break;
			}

		}
		int sum[];
		if (value == -1) {
			sum = new int[1];
			sum[0] = value;
		} else {
			Collections.reverse(sumArray);
			sum = sumArray.stream().mapToInt(i -> i).toArray();
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
