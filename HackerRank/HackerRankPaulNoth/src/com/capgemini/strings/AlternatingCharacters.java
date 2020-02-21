package com.capgemini.strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlternatingCharacters {

	

	    // Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		 ArrayList<Character> s1 = new ArrayList<Character>();
	        s1.add('?');
	        int count =0;
	        for (int i = 0; i < s.length(); i++) {
	            if(s.charAt(i) == s1.get(s1.size()-1) ) {
	                count++;
	                continue;
	            } else if(s.charAt(i) != s1.get(s1.size()-1)) {
	               s1.add(s.charAt(i));
	            }
	        }

	        return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter a String: ");
		String s = scanner.nextLine();
		int numberDeletions = alternatingCharacters(s);
		System.out.println("The number of deletions that needs to be made is: " + numberDeletions);
	}
}
