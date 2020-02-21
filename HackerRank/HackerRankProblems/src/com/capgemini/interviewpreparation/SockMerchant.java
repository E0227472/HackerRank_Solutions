package com.capgemini.interviewpreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

	static int sockMerchant(int n, int[] ar) {
		Arrays.sort(ar);
		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
		List<Integer> totalPairs = new ArrayList<Integer>();

		// checking every element of the inputArray
		for (int i : ar) {
			if (elementCountMap.containsKey(i)) {
				// If element is present in elementCountMap, incrementing it's count by 1
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				// If element is not present in elementCountMap,
				// adding this element to elementCountMap with 1 as it's value
				elementCountMap.put(i, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
			int value = entry.getValue();
			int numPairs = value / 2;
			totalPairs.add(numPairs);
		}
		
		 int sum = totalPairs.stream().mapToInt(Integer::intValue).sum();
		 
		 return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		for (int a : ar)
			System.out.println(a);
		 int result = sockMerchant(n, ar);
		scanner.close();

		 System.out.println("The result is: " + result);
	}

}
