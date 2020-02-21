package com.capgemini.practise;

import java.io.IOException;
import java.util.Scanner;

public class BeautifulDays {

	// Complete the beautifulDays function below.
	static int beautifulDays(int i, int j, int k) {
		int count = 0;
		for (int index = i; index <= j; index++) {
			String value = String.valueOf(index);
			StringBuilder sb = new StringBuilder(value);
			sb.reverse();
			String reversedValue = sb.toString();
			int valueReversed = Integer.parseInt(reversedValue);
			int result = (index - valueReversed) % k;
			if(result == 0)
				count++;
		}
		
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the first number in array, second number and the divisible number k");

		String[] ijk = scanner.nextLine().split(" ");

		int i = Integer.parseInt(ijk[0]);

		int j = Integer.parseInt(ijk[1]);

		int k = Integer.parseInt(ijk[2]);

		int result = beautifulDays(i, j, k);

		System.out.println(String.valueOf(result));

		scanner.close();
	}

}
