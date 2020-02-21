package com.capgemini.strings;

import java.io.IOException;
import java.util.Scanner;

public class BinaryString {

	static int beautifulBinaryString(String b) {
		int count = 0;
		// length of b. b is variable and keeps changing.
		int newIndexb = 0;
		// searching starts from back to front. condition is while greater than 0.
		while (newIndexb <= b.length() - 3 && newIndexb >= 0) {
			// if substring match
			if (b.substring(newIndexb, newIndexb + 3).equals("010")) {
				count++;
				// System.out.println(newIndexb);
				if ((newIndexb + 3) >= b.length())
					break;
				else
					b = b.substring(newIndexb + 3);
				newIndexb = 0;
			} else { // => if substring does not match, increase the index.
				newIndexb++;
				// System.out.println(newIndexb);
			}
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a String value: ");
		String s = scanner.nextLine();
		int result = beautifulBinaryString(s);
		System.out.println(s + " :changes that need to be made are: " + result);
	}

}
