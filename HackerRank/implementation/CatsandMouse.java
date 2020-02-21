package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class CatsandMouse {

	// Complete the catAndMouse function below. 
	// x = A; y = B; z = C
	static String catAndMouse(int x, int y, int z) {
		int diffx = Math.abs(z-x);
		int diffy = Math.abs(z-y);
		
		if(diffx > diffy) // => if A is further away from C than B is.
			return "Cat B";
		else if (diffy > diffx)
			return "Cat A";
		else 
			return "Mouse C";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of queiries: ");
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] xyz = scanner.nextLine().split(" ");

			int x = Integer.parseInt(xyz[0]);

			int y = Integer.parseInt(xyz[1]);

			int z = Integer.parseInt(xyz[2]);

			String result = catAndMouse(x, y, z);
			
			System.out.println(result);

		}

		scanner.close();
	}

}
