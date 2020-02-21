package com.capgemini.DBS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// get the number of operations/elements
		System.out.println("How many operations(same number as elements) do you wish to perform? ");
		int numOperations = Integer.parseInt(sc.next());

		// get the operations
		System.out.println("Enter the operations: ");
		String[] operations = new String[numOperations];
		for (int i = 0; i < numOperations; i++) {
			operations[i] = sc.next();
		}

		// Get the elements
		System.out.println("Enter the elements: ");
		int[] elements = new int[numOperations];
		for (int i = 0; i < numOperations; i++) {
			elements[i] = Integer.parseInt(sc.next());
		}

		// Determine if should push or pull to arraylist based on operations
		List<Integer> eleOperations = new ArrayList<Integer>();
		List<Integer> eleProduct = new ArrayList<Integer>();
		for (int i = 0; i < numOperations; i++) {
			if (operations[i].equals("push"))
				eleOperations.add(elements[i]);
			else if(operations[i].equals("pop"))
				eleOperations.remove(new Integer(elements[i]));

			Integer max = eleOperations.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

			Integer min = eleOperations.stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new);

			int prod = max * min;
			System.out.println(max + " * " + min + "= " + prod);
		}

		for (int product : eleProduct) {
			System.out.println(product);
		}

	}

}
