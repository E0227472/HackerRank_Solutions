package com.capgemini.customclass;

import java.util.Scanner;

public class NameExtractor {

	static String[] names(String[] s) {
		String url = "https://linkedin.com/in/";

		for (int i = 0; i < s.length; i++) {
			s[i] = s[i].replaceAll(url, "");
			s[i] = s[i].replaceAll("/", "");
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
			urls [i] = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		}

		urls = names(urls);

		for (String name : urls)
			System.out.println(name);

	}

}
