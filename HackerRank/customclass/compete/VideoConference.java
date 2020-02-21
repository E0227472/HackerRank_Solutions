package com.capgemini.compete;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

	public static List<String> solve(List<String> names) {
		// create 2 Sets, one set is the answer the other set all the possible prefixes
		// (or substrings),
		// There should not be an overlap of substrings

		// Linked list helps maintain the order of the prefixes
		List<String> ans = new LinkedList<String>();

		// Set to store all possible prefixes of a given name.
		// According to use case, prefixes should not overlap previous prefixes even
		// though not in use
		Set<String> prefixes = new HashSet<String>();

		// Map that stores the names that has already been used before
		Map<String, Integer> nameStorage = new HashMap<String, Integer>();
		boolean prefixInserted = false;
		for (String name : names) {
			if (nameStorage.containsKey(name)) {
				int countName = nameStorage.get(name);
				String prefix = name + " " + String.valueOf(countName);
				nameStorage.put(name, countName + 1);
				ans.add(prefix);
			} else {
				prefixInserted = false;
				// check to see if prefix exists in the prefixes, if doesnt exist, add to answer
				// and quit loop.
				for (int i = 1; i <= name.length(); i++) {
					String prefix = name.substring(0, i);
					if (!prefixes.contains(prefix)) {
						ans.add(prefix);
						prefixInserted = true;
						break;
					}
				}

				// add all the prefixes to the prefixes set to compare and see if they exist.
				for (int i = 1; i <= name.length(); i++) {
					String prefix = name.substring(0, i);
					if (!prefixes.contains(prefix))
						prefixes.add(prefix);
				}
				
				if(prefixInserted == false) {
					ans.add(name);
					nameStorage.put(name, 2);
				}
				
				nameStorage.put(name, 2);
					
			}

		}
		return ans;
	}

}

public class VideoConference {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter value for n, the number of names: ");
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine().trim());
		System.out.println("Enter the names: ");
		List<String> names = IntStream.range(0, n).mapToObj(i -> {
			return scanner.nextLine();
		}).collect(Collectors.toList());

		List<String> res = Result.solve(names);

		System.out.println(res.stream().collect(joining("\n")) + "\n");
		scanner.close();
	}

}
