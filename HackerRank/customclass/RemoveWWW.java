package com.capgemini.customclass;

import java.util.Scanner;

public class RemoveWWW {

	static String[] names(String[] s) {
		String url = "https://www.linkedin.com/in/";

		for (int i = 0; i < s.length; i++) {
			s[i] = s[i].replaceAll("www.", "");
		}

		return s;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of url profiles: ");

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] urls = new String[n];
		System.out.println("Enter the url links: ");

		for (int i = 0; i < n; i++) {
			urls[i] = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		}

		urls = names(urls);
		System.out.println();
		for (String name : urls) {
			System.out.println(name);
		}

	}

}
