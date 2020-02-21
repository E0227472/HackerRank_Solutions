package com.capgemini.implementation;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'pickingNumbers' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY a as parameter.
	 */

	public static int pickingNumbers(List<Integer> a) {
		Map<Integer, Integer> countFrequency = new TreeMap<Integer, Integer>();
		// counting the frequency of each integer
		for (int k : a) {
			countFrequency.put(k, (!countFrequency.containsKey(k)) ? 1 : countFrequency.get(k) + 1);
		}
		int previouskey = 0;
		int previousvalue = 0;
		int count = 0;
		List<Integer> maxCount = new LinkedList<Integer>();
		for (Map.Entry<Integer, Integer> val : countFrequency.entrySet()) {
			int currentkey = val.getKey();
			int currentvalue = val.getValue();
			maxCount.add(currentvalue);
			if(previouskey != 0) {
				int diff = Math.abs(previouskey - currentkey);
				if(diff <=1) {
					count = currentvalue + previousvalue;
					maxCount.add(count);
				}
			}
			
			previouskey = val.getKey();
			previousvalue = val.getValue();
			count = 0;
		}
		
		int result = Collections.max(maxCount);
		return result;
	}

}

public class PickingNumbers {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the List: ");
		int n = Integer.parseInt(scanner.nextLine().trim());

		List<Integer> a = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(Collectors.toList());

		int result = Result.pickingNumbers(a);

		System.out.println(String.valueOf(result));
		
	}

}
