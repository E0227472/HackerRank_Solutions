package com.capgemini.strings;

import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {

	// Complete the marsExploration function below.
	static int marsExploration(String s) {
		String sos = "SOS";
		int count = 0;
		//iterate the String in increments of 3
		for (int i = 0; i < s.length(); i+= 3) {
			String sub = s.substring(i, i+3);
			if(sub.equals("SOS"))
				continue;
			else {
				// loop through the substring and compare individual characters with sos. 
				for(int j = 0; j < sub.length(); j++) {
					if(sub.charAt(j) != sos.charAt(j))
						count++;
				}
			}
		}
		
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a String value: ");

		String s = scanner.nextLine();

		int result = marsExploration(s);

		System.out.println("The number of letters that needs to be changed: " + result);
	}

}
