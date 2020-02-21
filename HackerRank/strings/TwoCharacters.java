package com.capgemini.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a String: ");
		String s = sc.nextLine();
		String alts = null;
		String news = "";
		int countEven = 0;
		int countOdd = 0;
		// add the String lengths to the arraylist
		ArrayList<Integer> stringLengths = new ArrayList<Integer>();

		// loop through the string and get the pair of alternating characters as
		// substring
		for (int i = 0; i < s.length() - 1; i++) {
			alts = s.substring(i, i + 2);
			if(alts.charAt(0) == alts.charAt(1))
				continue;
			// looping through the string and adding only characters that match substring
			// pair.
			for (int j = 0; j < s.length(); j++) {
				// if characters match
				if (s.charAt(j) == alts.charAt(0) || s.charAt(j) == alts.charAt(1)) {
					String addChar = String.valueOf(s.charAt(j));
					news += addChar;
				}

			}
			 System.out.println("The new String is: " + news);
			// getting the first 2 characters of the substring and checking if they repeat in sequence
			 String subStringnews = null;
			 if(news.length() >= 2)
			 subStringnews = news.substring(0,2);
			 // looping through substring and check for alternate sequence
			for(int k = 0; k < news.length(); k++) {
				if(k % 2 == 0 && news.charAt(k) == subStringnews.charAt(0))
					countEven++;
				else if(k % 2 != 0 && news.charAt(k) == subStringnews.charAt(1))
					countOdd++;
			}
			
			int totalCount = countEven + countOdd;
			if(totalCount == news.length())
				stringLengths.add(news.length());
			 
			news = "";
			countEven = 0;
			countOdd = 0;
		}
		int maxLength = 0;
		
		if(stringLengths.size() ==0)
			maxLength =0;
		else
			 maxLength = Collections.max(stringLengths);
		System.out.println("The maximum String length is: " + maxLength);

	}
}
