package com.capgemini.practise;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnClouds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c, int k) {

		int power = 100;

		for (int i = 0 + k; i < c.length; i += k) {
			if (c[i] == 1) {
				power -= 3;
			} else {
				power -= 1;
			}
		}

		if (c[0] == 1)
			power -= 3;
		else
			power -= 1;

		return power;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter values for n and k respectively: ");

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] c = new int[n];
		System.out.println("Enter the array elements: ");

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c, k);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
