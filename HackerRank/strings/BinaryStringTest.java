package com.capgemini.strings;

import java.util.Scanner;

public class BinaryStringTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String b = scanner.nextLine();
		int count = 0;
		// length of b. b is variable and keeps changing. 
		int newIndexb = 0;
		// searching starts from back to front. condition is while greater than 0.
		while (newIndexb <= b.length()-3 && newIndexb >= 0) {
				// if substring match
				if (b.substring(newIndexb, newIndexb+3).equals("010")) {
					count++;
					//System.out.println(newIndexb);
					if((newIndexb+3) >= b.length())
						break;
					else
					b = b.substring(newIndexb+3);
					newIndexb = 0;
				}else { // => if substring does not match, increase the index. 
						newIndexb++;
						//System.out.println(newIndexb);
				}
		}
		
		System.out.println("The number of times string appears is: "+ count);
		
		

	}

}
