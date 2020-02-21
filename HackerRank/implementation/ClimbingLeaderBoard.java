package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingLeaderBoard {

	// Complete the climbingLeaderboard function below.
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		List<Integer> rank = new ArrayList<Integer>();

		int len = removeDuplicates(scores, scores.length);

//		for(int i = 0; i < scoresLength; i++)
//			System.out.println("The score elements are: " + scores[i]);

		for (int aliceEle : alice) {

			if (aliceEle >= scores[0]) {
				rank.add(1);
				continue;
			} else if (aliceEle <= scores[len - 1]) {
				rank.add(len + 1);
				continue;
			} else if (aliceEle < scores[len / 2]) {

				for (int j = len / 2; j < len; j++) {
					if (aliceEle >= scores[j]) {
						rank.add(j + 1);
						break;
					} 
				}
			} else if (aliceEle > scores[len / 2]) {
				for (int j = 0; j <= len / 2; j++) {
					if (aliceEle >= scores[j]) {
						rank.add(j + 1);
						break;
					}
				}
			}
		}

		return rank.stream().mapToInt(i -> i).toArray();

	}

	static int removeDuplicates(int[] arr, int n) {
		int[] temp = new int[n];

		// Start traversing elements
		int j = 0;
		for (int i = 0; i < n - 1; i++)
			// If current element is not equal
			// to next element then store that
			// current element
			if (arr[i] != arr[i + 1])
				temp[j++] = arr[i];

		// Store the last element as whether
		// it is unique or repeated, it hasn't
		// stored previously
		temp[j++] = arr[n - 1];

		// Modify original array
		for (int i = 0; i < j; i++)
			arr[i] = temp[i];

		return j;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of the array for leaderboard: ");

		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];
		System.out.println("Enter the array leaderboard scores: ");
		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}
		System.out.println("Enter the array size for player: ");
		int aliceCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];
		System.out.println("Enter the array elements for player: ");
		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = Integer.parseInt(aliceItems[i]);
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}

		scanner.close();
	}

}
