package com.capgemini.implementation;

import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {

	// Complete the caesarCipher function below.
	static String caesarCipher(String s, int k) {
		String news = "";
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int cInt = (int) c;
			if (k < 26) {
				cInt += k;
			} else {
				k = k % 26;
				cInt += k;
			}
			if (c >= 'a' && c <= 'z') {
				System.out.println("The " + c + " before shifting: " + cInt);
				if (cInt > 122) { // => if the characters are small letters
					cInt -= 122;
					cInt += 96;
				}
				System.out.println("The " + c + " after shifting: " + cInt);
				char shiftedc = (char) cInt;
				news += String.valueOf(shiftedc);
			} else if (c >= 'A' && c <= 'Z') {
				if (cInt > 90) { // => if the characters are big letters
					cInt -= 90;
					cInt += 64;
				}
				char shiftedc = (char) cInt;
				news += String.valueOf(shiftedc);
			} else {
				news += String.valueOf(c);
			}

		}

		return news;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the array size: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		System.out.println("Enter the String value: ");
		String s = scanner.nextLine();

		System.out.println("Enter the number of positions to shift: ");
		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = caesarCipher(s, k);

		System.out.println(result);

		scanner.close();
	}

}
