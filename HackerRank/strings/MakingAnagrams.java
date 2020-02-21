package com.capgemini.strings;
import java.util.Scanner;

public class MakingAnagrams {
	static final int MAX_CHAR = 26;

	static int makingAnagrams(String s1, String s2) {
		// two arrays of length 26 to store occurence
		// of a letters alphabetically for each string
		String common = "";
		int[] a1 = new int[MAX_CHAR];
		int[] a2 = new int[MAX_CHAR];

		int length1 = s1.length();
		int length2 = s2.length();
		// index refers to alphabet character unicode reference
		for (int i = 0; i < length1; i++)
			a1[s1.charAt(i) - 'a'] += 1;

		for (int i = 0; i < length2; i++)
			a2[s2.charAt(i) - 'a'] += 1;

		// If a common index is non-zero, it means
		// that the letter corresponding to that
		// index is common to both strings
		for (int i = 0; i < MAX_CHAR; i++) {
			if (a1[i] != 0 && a2[i] != 0) {
				// Find the minimum of the occurence
				// of the character in both strings and print
				// the letter that many number of times
				for (int j = 0; j < Math.min(a1[i], a2[i]); j++) {
					//System.out.print(((char) (i + 'a')));
					common += String.valueOf(((char) (i + 'a')));
				}
			}
		}
//		int counts1 = 0;
//		boolean s1matches = false;
//		int counts2 = 0;
//		boolean s2matches = false;
//		// Loop through String 1, check if each character is present in common. if not present, count++
//		for (int i = 0; i < s1.length(); i++) {
//			// Loop through common string and see if each character in String 1 is found in common
//			for(int j = 0; j < common.length(); j++) {
//				if(s1.charAt(i) == common.charAt(i)) {
//					
//				}
//			}
//		}
		
		int s1deletions = s1.length() - common.length();
		int s2deletions = s2.length() - common.length();
		int sumDeletions = s1deletions + s2deletions;
		return sumDeletions;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = makingAnagrams(s1, s2);
		
		System.out.println("The number of deletions that need to be made are: " + result);

		scanner.close();

	}

}
