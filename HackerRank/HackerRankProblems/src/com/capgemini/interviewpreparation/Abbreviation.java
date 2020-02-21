package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {

	// traverse both strings at the same time O(N) time complexity.
	// Traverse String b: String to be matched
	// check if the characters exist in String a. If they do, proceed forward.
	// this method preverses the order of the String.
	static String abbreviation(String a, String b) {
		String result = null;
		String balanceCharacters = null;
		String originala = a;
		String originalb = b;
		int aLength = a.length();
		int bLength = b.length();
		int j = 0;
		int k = 0;
		int i = 0;
		boolean upperCase = false;
		if (a.equals(b))
			result = "NO";
		else {
			a = a.toLowerCase(); // original String
			b = b.toLowerCase(); // Modified String
			for (i = 0; i < aLength && j < bLength; i++) {
				if (b.charAt(j) == a.charAt(i)) {
					k++;
					j++;
				} else {
					if (Character.isUpperCase(originala.charAt(i))) {
						upperCase = true;
						break;
					}
					k++;
				}
			}
			if (k == i) {
				if (j == bLength && upperCase == false) {
					result = "YES";
				} else
					result = "NO";
			
		} else {
			for(int z = k; z < aLength; z++) {
				if(Character.isUpperCase(originala.charAt(z))) {
					upperCase = true;
					break;
				}
			}
		}
			if(upperCase == true)
				result = "NO";
			else {
				if (j == bLength && upperCase == false) {
					result = "YES";
				} else
					result = "NO";
			}
		}
				
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("Enter values for String a and b respectively: ");
		for (int qItr = 0; qItr < q; qItr++) {
			String a = scanner.nextLine();

			String b = scanner.nextLine();

			String result = abbreviation(a, b);

			System.out.println(result);
		}
		scanner.close();
	}

}
