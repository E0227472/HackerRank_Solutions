package com.capgemini.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndAnagram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int result = sherlockAndAnagrams(s);

		 System.out.println( result);
		//sherlockAndAnagrams(s);

	}

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		List<String> forward = new ArrayList<String>();
		String resultForward = "";

		// find all the substrings of string in forward direction
		char[] charsForward = s.toCharArray();
		// pick starting point, starting from index 1 and ending at index len.
		for (int len = 1; len <= charsForward.length; len++) {
			// pick ending point, starting from index 0 and ending at index n - len.
			for (int i = 0; i <= charsForward.length - len; i++) {
				// print characters from current starting point to current ending point.

				int j = i + len - 1;
				for (int k = i; k <= j; k++) {
					resultForward += String.valueOf(charsForward[k]);
				}
				//System.out.println("The substrings are: " + resultForward);
				forward.add(resultForward);
				resultForward = "";
			}
		}
		
		int count = 0;

		// outer loop to choose element to compare with rest of elements in arraylist
		for(int i = 0; i < forward.size() -1; i++) {
			for(int j = i+1; j < forward.size(); j++) {
				int elementLength = forward.get(i).length();
				int remainderLength = forward.get(j).length();
				// if lengths not the same, they are not anagrams of each other
				if(elementLength != remainderLength)
					continue;
				
				char [] str1 = forward.get(i).toCharArray();
				char[] str2 = forward.get(j).toCharArray();
				// Sort both Strings by alphabetical order. 
				Arrays.sort(str1);
				Arrays.sort(str2);
				// convert the char arrays to String 
				String a = new String(str1);
				String b = new String(str2);
				
				if(a.equals(b))
					count++;
				else 
					continue;
			}
		}
		
		return count;

	}

}
