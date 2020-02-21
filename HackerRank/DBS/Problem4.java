package com.capgemini.DBS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int countNonUnique = 0;
		// get the size of the array
		System.out.println("Enter the size of the array: ");
		int n = Integer.parseInt(sc.next());
		int[] arrayElements = new int[n];
		// Enter the elements to the array
		System.out.println("Enter the elements to the array");
		for (int i = 0; i < arrayElements.length; i++) {
			arrayElements[i] = Integer.parseInt(sc.next());
		}

		// sort the Arrays to get all the elements to be grouped together
		Arrays.sort(arrayElements);

		// count the number of occurances of each element. Store it as a key in map so
		// no repetitions of elements
		HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();
		for (int element : arrayElements) {
			if (repetitions.containsKey(element))
				repetitions.put(element, repetitions.get(element) + 1);
			else
				repetitions.put(element, 1);
		}

		for (Map.Entry<Integer, Integer> e : repetitions.entrySet()) {
			if (e.getValue() > 1)
				countNonUnique++;
		}
		
		System.out.println(countNonUnique);
	}

}
