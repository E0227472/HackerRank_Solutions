package com.capgemini.implementation;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class BirthDayChocolate {

	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {
		int[] sArray = s.stream().mapToInt(i -> i).toArray();
		int countLength = 0;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < sArray.length; i++) // This loop will select start element
		{
			for (int j = i; j < sArray.length; j++) // This loop will select end element
			{
				if ((j - i + 1) != m)
					continue;
				else {
					for (int k = i; k <= j; k++) // This loop will print element from start to end

					{
						sum += sArray[k];
						countLength++;
					}

					if (countLength == m && sum == d) {
						count++;
						System.out.println("The count is: " + count);
					}
					System.out.println("The sum is: " + sum);
					System.out.println("The countLength is: " + countLength);
					sum = 0;
					countLength = 0;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = Integer.parseInt(scanner.nextLine().trim());

		System.out.println("Enter the array elements: ");
		List<Integer> s = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		System.out.println("Enter integers d and m: ");
		String[] dm = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		int d = Integer.parseInt(dm[0]);

		int m = Integer.parseInt(dm[1]);

		int result = birthday(s, d, m);

		System.out.println(String.valueOf(result));

	}

}
