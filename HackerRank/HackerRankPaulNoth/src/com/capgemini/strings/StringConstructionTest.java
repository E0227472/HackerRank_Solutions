package com.capgemini.strings;

import java.util.Scanner;

public class StringConstructionTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String value: ");
		String s = scanner.nextLine();
		StringBuilder sb = new StringBuilder("");
		int count = 0;
		
			while (!s.equals(sb.toString())) { // => if strings dont match append one character from s. 
				sb.append(s.charAt(0));
				count++;
				System.out.println(count);
				System.out.println(sb.toString());
				System.out.println(s);
				if ((s.length() - 1) == 0) { // => if s.length() -1 == 0, means 1 character left.
					break;
				} else if ((s.length() - 1) > 0) { // => if s.length() - 1 > 0, means 2 characters and above
					s = s.substring(1);
				} else if ((s.length() - 1) < 0) // => s.length() - 1 < 0 means s is empty now.
					break;
			}
		
		
		System.out.println("Total cost is= " + count);

	}

}
