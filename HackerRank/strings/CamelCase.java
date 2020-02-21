package com.capgemini.strings;

import java.io.IOException;
import java.util.Scanner;

public class CamelCase {
	 // Complete the camelcase function below.
    static int camelcase(String s) {
        int count = 1;
        for(int i = 0; i < s.length(); i++ ) {
            if(Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    
    	System.out.println("Enter a string");
        String s = scanner.nextLine();

        int result = camelcase(s);
        System.out.println(result);
    }

}
