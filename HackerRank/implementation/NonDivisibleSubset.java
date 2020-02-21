package com.capgemini.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubset {

	// Complete the nonDivisibleSubset function below.
	// divisible factor = k; S = array;
	static int nonDivisibleSubset(int k, int[] S) {
		int f[] = new int[k];
		Arrays.fill(f, 0);
		Arrays.sort(S);
		Set<Integer> set = new HashSet<Integer>();

		for (int ele : S)
			set.add(ele);
		// adding the frequency of the remainders of each element. the remainders are
		// the index.
		for (int i = 0; i < S.length; i++)
			f[S[i] % k]++;

		if (k % 2 == 0)
			f[k / 2] = Math.min(f[k / 2], 1);

		int res = Math.min(f[0], 1);

		for (int i = 1; i <= k / 2; i++)
			res += Math.max(f[i], f[k - i]);

		return res;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the array size and the divisible factor respectively:");

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] S = new int[n];

		System.out.println("Enter the array elements: ");
		String[] SItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int SItem = Integer.parseInt(SItems[i]);
			S[i] = SItem;
		}

		int result = nonDivisibleSubset(k, S);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
