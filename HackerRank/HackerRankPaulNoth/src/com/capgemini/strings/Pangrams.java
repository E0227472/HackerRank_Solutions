package com.capgemini.strings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

	// Complete the pangrams function below.
	static String pangrams(String s) {
		String output = s.replaceAll("\\s+","");
		String lowercaseOutput = output.toLowerCase();
		Set<Character> sChars = new HashSet<Character>();
		for(int i = 0; i < lowercaseOutput.length(); i++) {
			sChars.add(lowercaseOutput.charAt(i));
		}
		
		if(sChars.size() == 26) 
			return "pangram";
		else 
			return "not pangram";

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter a sentence: ");
		String s = scanner.nextLine();

		String result = pangrams(s);
		System.out.println(result);
		
	}

}
