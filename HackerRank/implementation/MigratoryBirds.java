package com.capgemini.implementation;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.Map.Entry; 

public class MigratoryBirds {

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int ele : arr)
			map.put(ele, !map.containsKey(ele) ? 1 : map.get(ele) + 1);

		// find max frequency.
		int max_count = 0, res = -1;

		for (Entry<Integer, Integer> val : map.entrySet()) {
			if (max_count < val.getValue()) {
				res = val.getKey();
				max_count = val.getValue();
			}
		}
		
		return res;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size: ");
		int arrCount = Integer.parseInt(scanner.nextLine().trim());

		System.out.println("Enter the array elements: ");
		List<Integer> arr = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = migratoryBirds(arr);

		System.out.println(String.valueOf(result));

	}

}
