package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SherlockandValidString {

	// Complete the isValid function below.
	static String isValid(String s) {
		String result = null;
		
		if (s.length() <= 2 && s.length() > 0)
			result = "YES";
		else {

			Map<Character, Integer> map = new TreeMap<Character, Integer>();
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			for (int i = 0; i < chars.length; i++) {
				map.put(chars[i], !map.containsKey(chars[i]) ? 1 : map.get(chars[i]) + 1);
			}

			Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();

			// adding the frequency of each elements and determining their count
			for (Map.Entry<Character, Integer> val : map.entrySet()) {
				int key = val.getValue();
				System.out.println("The frequency for " + val.getKey() + " is: "+ key);
				mapCount.put(key, !mapCount.containsKey(key) ? 1 : mapCount.get(key) + 1);
			}

			if (mapCount.size() > 2)
				result = "NO";
			else if (mapCount.size() == 1)
				result = "YES";
			else if (mapCount.size() == 2) {
				int [] count = new int [2];
				int[] keys = new int [2];
				int i = 0;
				int j = 0;
				for (Map.Entry<Integer, Integer> val : mapCount.entrySet()) {
					System.out.println("The values for frequency count is: " + val.getValue());
					count[i++] = val.getValue();
					keys[j++] = val.getKey();
				}
				if(count[0] > 1 && count[1] > 1)
					result = "NO";
				else if(Math.abs(keys[0] - keys[1]) ==1 && (count[0] ==1 || count[1] ==1))
					result = "YES";
				else if((keys[0] ==1 && count[0] ==1) || (keys[1] == 1 && count[1] ==1))
					result = "YES";
				else 
					result = "NO";
			}
		}
		
		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a value for s: ");

		String s = scanner.nextLine();

		String result = isValid(s);

		System.out.println(result);

		scanner.close();
	}

}
