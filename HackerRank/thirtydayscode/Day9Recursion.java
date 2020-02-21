package com.capgemini.thirtydayscode;

import java.util.Scanner;

public class Day9Recursion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value to perform recurssion with: ");
		int N = Integer.parseInt(scanner.nextLine());
		int product = 1;
		for(int i = 1; i < N+1; i++) {
			product *= i;
		}
		System.out.println(product);

	}

}
