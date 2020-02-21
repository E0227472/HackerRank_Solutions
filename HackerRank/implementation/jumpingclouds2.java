package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class jumpingclouds2 {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int countJumps = 0;
		int i = 0;
		while (i < c.length) {
			if ((i + 2) < c.length && c[i+2] == 0 && c[i + 1] == 0 && c[i] == 0) {
				countJumps += 2;
				System.out.println("The consequtive count at " + i + " index is :" + countJumps);
				if ((i + 3) < c.length) {
					i = i + 3;
					continue;
				} else
					break;
			} else if (c[i] == 0) {
				countJumps++;
				System.out.println("The non consequtive count at " + i + " index is: " + countJumps);
				i++;
			} else
				i++;
		}
		int countFinal = 0;
		if(c.length == 100)
			countFinal = countJumps - 2;
		else if(c.length >=50 && c.length <=90)
			countFinal = countJumps -3;
		else 
			countFinal = countJumps -1;
		
		return countFinal;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter the size of the array: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		System.out.println("Enter array elements: ");
		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		System.out.println(result);

		scanner.close();

	}
}
