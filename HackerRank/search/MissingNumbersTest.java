package com.capgemini.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MissingNumbersTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of first array: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] brr = new int[n];
		System.out.println("Enter first array elements: ");
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			brr[i] = arrItem;
		}
		System.out.println("Enter size of second array: ");
		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[m];
		System.out.println("Enter second array elements: ");
		String[] brrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int brrItem = Integer.parseInt(brrItems[i]);
			arr[i] = brrItem;
		}
// arr longer array, brr shorter array.
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> brrList = Arrays.stream(brr).boxed().collect(Collectors.toList());
		for (int x : brrList)
			System.out.println(x + " " + brrList.size());
		
		//brrList.removeAll(arrList);
		

//		// completely missing numbers exist
//		if (brrList.size() != 0) {
//			List<Integer> missingNumsList = new ArrayList<Integer>();
//			Set<Integer> brrSet = new TreeSet(brrList);
//			for (int x : brrSet)
//				missingNumsList.add(x);
//
//			for (int aaa : missingNumsList)
//				System.out.println("the missing numbers are: " + aaa);
//		}

	}
	
	// test data
	//10
	// 11 4 11 7 13 4 12 11 10 14
	// 15
	// 11 4 11 7 3 7 10 13 4 8 12 11 10 14 12
}
