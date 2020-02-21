package com.capgemini.compete;

import java.util.Scanner;

public class ShuffleNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int A = Integer.parseInt(scanner.nextLine());

		System.out.println(String.valueOf(solution(A)));

	}

	public static int solution(int A) {

		String aString = String.valueOf(A);
		String result = "";

		if (aString.length() >= 3 && aString.length() % 2 == 0) {
			for (int i = 0; i < aString.length() / 2; i++) {
				result += aString.charAt(i);
				result += aString.charAt(aString.length() - i - 1);
				System.out.println(result);
			}
		} else if (aString.length() >= 3 && aString.length() % 2 != 0) {
			for (int i = 0; i < aString.length() / 2; i++) {
				result += aString.charAt(i);
				result += aString.charAt(aString.length() - i - 1);
				if (i + 1 == aString.length() / 2) {
					result += aString.charAt(aString.length() / 2);
					break;
				}
				System.out.println(result);
			}
		} else if (aString.length() == 2) {
			result += aString.charAt(1);
			result += aString.charAt(0);
		} else {
			result = aString;
		}

		int answer = Integer.parseInt(result);

		return answer;
	}

}
