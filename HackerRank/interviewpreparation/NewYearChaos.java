package com.capgemini.interviewpreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewYearChaos {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		// convert the array to a list
		// List<Integer> swapList =
		// Arrays.stream(q).boxed().collect(Collectors.toList());
		int countSwaps = 0;

		int[] qSorted;

		qSorted = Arrays.copyOfRange(q, 0, q.length);

		Arrays.sort(qSorted);
		boolean chaos = false;

		for (int i = 0; i < q.length - 1; i++) {
			if ((q[i] - q[i + 1]) >= 3) {
				chaos = true;
				break;
			}
		}

		if (chaos == false) {
			while (!Arrays.equals(q, qSorted)) {
				// loop through array and find elements to swap with
				for (int i = 0; i < q.length - 1; i++) {
					if ((q[i] - q[i + 1]) >=1) {
						int temp = q[i];
						q[i] = q[i + 1];
						q[i + 1] = temp;
						countSwaps++;
						for (int a : q)
							System.out.print(a + " ");
					}
					System.out.println();
				}

			}

			System.out.println(countSwaps);
		} else
			System.out.println("Too chaotic");

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of test cases: ");
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		System.out.println("Enter the array size: ");
		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			System.out.println("Enter the array elements: ");
			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}

}
