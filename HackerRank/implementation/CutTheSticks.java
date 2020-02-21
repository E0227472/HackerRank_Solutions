package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CutTheSticks {

	// Complete the cutTheSticks function below.
	static int[] cutTheSticks(int[] arr) {

		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> arrLengths = new ArrayList<Integer>();

		while (arrList.size() > 0) {
			Collections.sort(arrList);
			int min = Collections.min(arrList);
			arrList.removeAll(Collections.singleton(new Integer(min)));
			if (arrList.size() != 0)
				arrLengths.add(arrList.size());
		}

		int[] arrSizes;
		arrSizes = arrLengths.stream().mapToInt(i -> i).toArray();
		return arrSizes;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the length of the array: ");

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];
		System.out.println("Enter the elements for the array: ");

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] result = cutTheSticks(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}
		scanner.close();
	}

}
