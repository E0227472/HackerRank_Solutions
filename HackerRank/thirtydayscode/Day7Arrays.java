package com.capgemini.thirtydayscode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day7Arrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value for the array size: ");
		int N = Integer.parseInt(scanner.nextLine());
		Integer [] arrayElements = new Integer[N];
		System.out.println("Enter the array elements: ");
		for(int i = 0; i < N; i++) {
			 arrayElements[i] = Integer.parseInt(scanner.nextLine());
		}
		List<Integer> array = Arrays.asList(arrayElements);
		Collections.reverse(array);
		Integer[] reversedArray = array.toArray(arrayElements);
		for(Integer a: reversedArray)
			System.out.println(a);
		
		
	}

}
