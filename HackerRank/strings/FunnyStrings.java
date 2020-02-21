package com.capgemini.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FunnyStrings {

	// Complete the funnyString function below.
	static String funnyString(String s) {
		int forwards [] = new int [s.length() -1];
		for (int i = 1; i < s.length(); i++) {
			int difference = Math.abs(s.charAt(i) - s.charAt(i-1));
			forwards[i-1] = difference; 
		}
		
		StringBuilder sb = new StringBuilder(s);
		String reverseString = sb.reverse().toString();
		
		int reverses [] = new int [s.length() -1];
		for (int i = 1; i < reverseString.length(); i++) {
			int difference = Math.abs(reverseString.charAt(i) - reverseString.charAt(i-1));
			reverses[i-1] = difference; 
		}
		
		boolean comp = Arrays.equals(forwards, reverses);
		
		if(comp == true) 
			return "Funny";
		else 
			return "Not Funny";
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a String Value: ");
		String s = scanner.nextLine();
		String result = funnyString(s);
		System.out.println(s + " is " + result);
		
	}
}
