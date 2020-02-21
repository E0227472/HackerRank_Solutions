package com.capgemini.thirtydayscode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10BinaryNumbers {

	public static void main(String[] args) {
		String binaryNumbers = Integer.toBinaryString(5);
		System.out.println(binaryNumbers);
		int count = 1;
		List<Integer> conseq1 = new ArrayList<Integer>();
		// default value of key 1 is 1, since all binary value will have at least one 1.
		for(int i = 1; i < binaryNumbers.length(); i++) {
			if(binaryNumbers.charAt(i-1) == binaryNumbers.charAt(i) && binaryNumbers.charAt(i-1) ==  '1') {
				count++;
				conseq1.add(count);
			} else {
				count = 1;
				conseq1.add(count);
			}
		}
		
		int maxvalue = Collections.max(conseq1);
	
		System.out.println("The maximum number of consequtive 1's are: " + maxvalue);

	}

}
