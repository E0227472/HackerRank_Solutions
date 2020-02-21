package com.capgemini.practise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String s = "";
		Stack<String> sCopies = new Stack<String>();

		for (int i = 1; i <= N; i++) {

			int query = Integer.parseInt(scanner.next());

			switch (query) {

			case 1: {
				String inputElement = scanner.next();
				sCopies.push(s);
				s += inputElement;
				break;
			}

			case 2: {
				int inputElement = scanner.nextInt();
				sCopies.push(s);
				int k = inputElement;
				s = s.substring(0, s.length() - k);
				break;
			}

			case 3: {
				int inputElement = scanner.nextInt();
				char c = s.charAt(inputElement - 1);
				System.out.println(c);
				break;
			}

			case 4: {
				s = sCopies.pop();
				break;
			}

			}
		}

	}

}
