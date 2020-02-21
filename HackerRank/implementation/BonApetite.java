package com.capgemini.implementation;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class BonApetite {

	// Complete the bonAppetit function below.
	static void bonAppetit(List<Integer> bill, int k, int b) {
		bill.remove(k);
		int sum = bill.stream().mapToInt(Integer::intValue).sum();
		if((sum/2) == b)
			System.out.println("Bon Appetit");
		else 
			System.out.println((b - (sum/2)));
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size and the index of item in array anna didnt eat: ");
		String[] nk = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		System.out.println("Enter the array elements: ");
		List<Integer> bill = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int b = Integer.parseInt(scanner.nextLine()
				.trim());

		bonAppetit(bill, k, b);

	}

}
