package com.capgemini.practise;

import java.io.IOException;
import java.util.Scanner;

public class UtopianTree {

	// Complete the utopianTree function below.
	static int utopianTree(int n) {
		int height = 1;
		for(int i = 1; i <= n; i++) {
			if( i % 2 == 0) {
				height += 1;
				System.out.println("Height at " + i + " is " + height );
			}
			else {
				height *= 2;
				System.out.println("Height at " + i + " is " + height );
			}
		}
		
		return height;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the total number of test cases: ");

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Enter the values for n: ");
		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int result = utopianTree(n);

			System.out.println(String.valueOf(result));
		}

		scanner.close();
	}

}
