package com.capgemini.practise;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String[] splitted = null;
		String s = "";
		//List<String> sCopies = new ArrayList<String>();
		Stack<String> sCopies = new Stack<String>();

		for (int i = 1; i <= N; i++) {
			// System.out.println("Enter the query ");
			String query = scanner.nextLine();
			int inputQuery = 0;
			String inputElement = null;

			if (query.length() > 1) {
				splitted = query.split("\\s+");
				inputQuery = Integer.parseInt(splitted[0]);
				inputElement = splitted[1];
			} else {
				inputQuery = Integer.parseInt(query);
			}

			switch (inputQuery) {

			case 1: {
				sCopies.add(s);
				s += inputElement;
				// System.out.println(s);
				break;
			}

			case 2: {
				sCopies.add(s);
				int k = Integer.parseInt(inputElement);
				s = s.substring(0, s.length() - k);
				// System.out.println(s);
				break;
			}

			case 3: {
				int k = Integer.parseInt(inputElement);
				int index = k - 1;
				char c = s.charAt(index);
				System.out.println(c);
				break;
			}

			case 4: {
				String lastString = sCopies.get(sCopies.size() - 1);
				s = lastString;
				// System.out.println(lastString);
				sCopies.remove(sCopies.size() - 1);
				break;
			}

			}
		}
		scanner.close();
	}

}
