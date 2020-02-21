package com.capgemini.DBS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] numbers = new String[6];
		System.out.println("Enter 6 Strings: ");

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.next();
		}

		List<String> balance = new ArrayList<String>();
		List<Long> numbersAdded = new ArrayList<Long>();

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i].length() < 19) {
				numbersAdded.add(Long.parseLong(numbers[i]));
			} else {
				balance.add(numbers[i]);
			}
		}

		Collections.sort(numbersAdded);
		Collections.sort(balance);
		for(long element: numbersAdded) {
			System.out.println(element);
		}
		for(String element: balance) {
			System.out.println(element);
		}
	}

}
