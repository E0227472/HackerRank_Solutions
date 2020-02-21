package com.capgemini.thirtydayscode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8DictonariesMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Map<String,Integer> phoneBook = new HashMap<String, Integer>();
		System.out.println("Enter the number of entries you wish to make: ");
		int N = Integer.parseInt(scanner.nextLine());
		for(int i = 0; i < N; i++) {
			phoneBook.put(scanner.next(), Integer.parseInt(scanner.next()));
		}
		
		
	}

}
