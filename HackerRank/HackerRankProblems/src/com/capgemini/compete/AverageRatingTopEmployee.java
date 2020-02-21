package com.capgemini.compete;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class AverageRatingTopEmployee {

	// Complete the averageOfTopEmployees function below.
	static void averageOfTopEmployees(int[] rating) {
		Arrays.sort(rating);
		double countRatings = 0;
		double sumRatings = 0;
		
		for (int i = rating.length - 1; i >= 0; i--) {
			if(rating[i] >= 90) {
				countRatings++;
				sumRatings += rating[i];
				//System.out.println("sumRatings is: " + sumRatings + " and countRatings is: " + countRatings);
			} else 
				break;
		}
		
		double averageRating = sumRatings / countRatings;
		averageRating = Math.round(averageRating * 100.0) / 100.0;
		DecimalFormat df = new DecimalFormat("##.00");
		System.out.println(df.format(averageRating));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a value for n, the number of employees: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] rating = new int[n];
		System.out.println("Enter values for employee's ratings: ");
		for (int ratingItr = 0; ratingItr < n; ratingItr++) {
			int ratingItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			rating[ratingItr] = ratingItem;
		}

		averageOfTopEmployees(rating);

		scanner.close();
	}

}
