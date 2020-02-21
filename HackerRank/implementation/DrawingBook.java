package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

	static int pageCount(int n, int p) {
		int count = 0;
		int countLeft = 0;
		int countRight = 0;

	  if (n % 2 == 0) {
			// count from left to right
			if (p % 2 == 0) {
				countLeft = p / 2;
				countRight = (n / 2) - (p / 2);
				if (countLeft < countRight)
					count = countLeft;
				else
					count = countRight;
			} else {
				p -= 1;
				countLeft = p / 2;
				countRight = (n / 2) - (p / 2);
				if (countLeft < countRight)
					count = countLeft;
				else
					count = countRight;
			}
		} else if (n % 2 != 0) {
			n -= 1;
			if (p % 2 == 0) {
				countLeft = p / 2;
				countRight = (n / 2) - (p / 2);
				if (countLeft < countRight)
					count = countLeft;
				else
					count = countRight;
			} else {
				p -= 1;
				countLeft = p / 2;
				countRight = (n / 2) - (p / 2);
				if (countLeft < countRight)
					count = countLeft;
				else
					count = countRight;
			}
		}
		
		return count;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the total number of pages in the book: ");
		int n = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		System.out.println("Enter the page number: ");
		int p = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int result = pageCount(n, p);

		System.out.println(String.valueOf(result));
		scanner.close();
	}

}
