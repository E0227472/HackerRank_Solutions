package com.capgemini.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HurdleRace {

	// Complete the hurdleRace function below.
	static int hurdleRace(int k, int[] height) {
		Arrays.sort(height);
		int doses = 0;
		int maxHurdleHeight = height[height.length-1];
		if(maxHurdleHeight <=k)
			doses = 0;
		else 
			doses = maxHurdleHeight - k;
		
		return doses;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of the array and natural jump height respectively:");

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] height = new int[n];
		System.out.println("Enter the array elements: ");
		String[] heightItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int heightItem = Integer.parseInt(heightItems[i]);
			height[i] = heightItem;
		}

		int result = hurdleRace(k, height);

		System.out.println(String.valueOf(result));

		scanner.close();
	}
}
