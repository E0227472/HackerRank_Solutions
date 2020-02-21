package com.capgemini.search;

import java.io.IOException;
import java.util.Scanner;

public class AngryProfessor {

	// Complete the angryProfessor function below.
	static String angryProfessor(int k, int[] a) {
		int count = 0;
		// counting the number of elements 
		for(int ele : a) {
			if(ele <= 0)
				count++;
		}
		
		if (count >= k)
			return "NO";
		else 
			return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// number of test cases 
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
		
			String[] nk = scanner.nextLine().split(" ");
			// size of array 
			int n = Integer.parseInt(nk[0]);
			// number of elements greater than or <= 0
			int k = Integer.parseInt(nk[1]);

			int[] a = new int[n];

			String[] aItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			// array elements 
			for (int i = 0; i < n; i++) {
				int aItem = Integer.parseInt(aItems[i]);
				a[i] = aItem;
			}

			String result = angryProfessor(k, a);
			
			System.out.println(result);
		
		}

		scanner.close();
	}

}
