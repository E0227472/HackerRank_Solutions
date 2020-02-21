package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class BreakingRecords {

	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {
		int countLowest = 0;
		int countHighest = 0;
		int tempLowest = scores[0];
		int tempHighest = scores[0];

		for (int i = 1; i < scores.length; i++) {
			if (Math.min(tempLowest, scores[i]) == scores[i] && scores[i] != tempLowest) {
				tempLowest = scores[i];
				countLowest++;
			} else if (Math.max(tempHighest, scores[i]) == scores[i] && scores[i] != tempHighest) {
				tempHighest = scores[i];
				countHighest++;
			} 
		}
		
		int [] result = new int [2];
		result[0] = countHighest;
		result[1] = countLowest;
		
		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of the array: ");

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[n];
		System.out.println("Enter the array elements: ");
		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int[] result = breakingRecords(scores);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}

		scanner.close();
	}

}
