package com.capgemini.strings;

import java.io.IOException;
import java.util.Scanner;

public class LoveLetter {
	// Complete the theLoveLetterMystery function below.
	static int theLoveLetterMystery(String s) {

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(i == s.length()-i-1) {
        		break;
        	} else if (i < s.length() -i - 1){
        		if(s.charAt(i) == s.charAt(s.length()-i-1)) {
        			continue;
        		} else {
        			int difference = Math.abs(s.charAt(i) - s.charAt(s.length()-i-1));
        			count += difference;
        		}
        	} else if (i > s.length() -i-1) {
        		break;
        	}
        }
        
        return count;

    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a String: ");
		String s = scanner.nextLine();
		int result = theLoveLetterMystery(s);

		System.out.println(result);
	}

}
