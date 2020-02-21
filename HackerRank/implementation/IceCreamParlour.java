package com.capgemini.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IceCreamParlour {

	// Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {
		int low = 0;
		int high = cost.length - 1;
		List<Integer> costList = Arrays.stream(cost).boxed().collect(Collectors.toList());

		Arrays.sort(cost);
		while (low < high) {
			if (cost[low] + cost[high] == money) {

				int lowIndex = costList.indexOf(cost[low]);
				int highIndex = costList.lastIndexOf(cost[high]);
				if(lowIndex < highIndex)
				System.out.println((lowIndex + 1) + " " + (highIndex + 1));
				else 
					System.out.println((highIndex + 1) + " " + (lowIndex + 1));
			}

			if (cost[low] + cost[high] < money)
				low++;
			else
				high--;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of test cases: ");
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Enter the total cost and array size respectively: ");
		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];
			System.out.println("Enter the array items: ");
			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavors(cost, money);
		}

		scanner.close();
	}

}
