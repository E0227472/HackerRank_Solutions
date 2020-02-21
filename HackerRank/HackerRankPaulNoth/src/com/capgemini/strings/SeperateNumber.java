package com.capgemini.strings;

import java.util.Scanner;

public class SeperateNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = scanner.nextLine();
		String sOriginal = s;
		String firstElement = null;
		String finalElement = null;
		int count = 0;
		int count9 = 1;
		int i = 1;
			// while loop to ensure that loop not exited
			while (i <= s.length()) {
				String s1 = s.substring(0, i); // => getting the first number of the string
				System.out.println("s1 is: " + s1);
				if(s.length() == sOriginal.length()) { // => getting only first element of original string
					firstElement = s1;
				}
				if(s1.charAt(0) == '0') { // => if starting number starts with 0
					s = sOriginal;
					i++;
					continue;
				}
				
				if (s1.equals(s) && s1.length() != sOriginal.length()) { // => if cannot obtain remaining string && reach end 
					count =1;
					finalElement = firstElement;
					break;
				} else {
					s = s.substring(i); // => getting the remaining string and instantiating with original string
					
					if(s1.length() > s.length()) {
						break;
					}
					
					System.out.println("s is " + s);
					long s1Num = Long.parseLong(s1); // => converting first digit to number
					long s1NumNext = s1Num + 1; // => checking if the +1 of first digit is in substring.
					String s1NumNextS = String.valueOf(s1NumNext); // => converting the next value to string
					// if the next value does not match, then move on to 2.
					if (!s.startsWith(s1NumNextS)) {
						s = sOriginal;
						i++;
						continue;
					} else if(s.startsWith(s1NumNextS) && s1.charAt(s1.length()-1) == '9') {
						for(int k = 1; k < s1.length(); k++) {
							if(s1.charAt(k) == s1.charAt(0)) {
								count9++;
							} 
						}
						
						if(count9 == s1.length()) {
							i++;
						} else 
							continue;
						
						
					} 
				}
			}
			

		if (count != 0 && finalElement != null)
			System.out.println("YES " + firstElement);
		else
			System.out.println("NO");
	}

}
