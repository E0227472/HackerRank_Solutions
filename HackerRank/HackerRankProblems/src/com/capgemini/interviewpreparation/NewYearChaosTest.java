package com.capgemini.interviewpreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewYearChaosTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		
		List<Integer> testData = new ArrayList<Integer> ();


			System.out.println("Enter the array elements: ");
			String[] qItems = scanner.nextLine().split(" ");
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			int i = 0;
			while (i < qItems.length) {
			    int j = Integer.parseInt(qItems[i]);
			    testData.add(j);
			    i++;
			}

			System.out.println(testData.size());

	}

}
