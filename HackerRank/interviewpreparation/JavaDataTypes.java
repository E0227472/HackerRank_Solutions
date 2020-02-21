package com.capgemini.interviewpreparation;

import java.util.Scanner;

public class JavaDataTypes {

	public static void main(String[] argh) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			try {
				long x = sc.nextLong();
				System.out.println(x + " can be fitted in:");
				
				if (x >= -128 && x <= 127) {
					System.out.println("* byte");
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				}
				else if((x <= -129 && x >= -32768) || (x <= 32767 && x >= 128)) {
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if( (x <= -32769 && x >= -2147483648) || (x <= 2147483647 && x >= 32769)) {
					System.out.println("* int");
					System.out.println("* long");
				} else if( (x <= -2147483649l && x >= -9223372036854775808l) || (x <= 9223372036854775807l 
						&& x >= 2147483648l)) {
					System.out.println("* long");
				}
					
			} catch (Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}

		}
	}
}
