package com.capgemini.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ViralAdvertising {

	// Complete the viralAdvertising function below.
	static int viralAdvertising(int n) {
		int currentdayLikes = 2;
		int totalLikes = 0;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				totalLikes = 2;
				continue;
			} else {
				currentdayLikes = (currentdayLikes * 3) / 2;
				System.out.println("The" + " " + (i) + " " + "day like is: " + currentdayLikes);
				totalLikes += currentdayLikes;
				System.out.println("The total number of likes are: " + totalLikes);
			}
		}

		return totalLikes;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = viralAdvertising(n);

		System.out.println(String.valueOf(result));
		scanner.close();
	}

}
