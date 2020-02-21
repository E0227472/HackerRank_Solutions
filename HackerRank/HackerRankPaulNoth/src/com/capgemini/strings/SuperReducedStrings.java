package com.capgemini.strings;

import java.io.IOException;
import java.util.Scanner;

public class SuperReducedStrings {

	// Complete the superReducedString function below.
    static String superReducedString(String s) {
     
     
     char [] str = s.toCharArray();
     
     int j = 0;

 
     for (int i = 1; i < s.length(); i++) {

     while ((j >= 0) && i < s.length() && (str[i] == str[j])) {
     i++;
     j--;
        }

    if (i < s.length())
    str[++j] = str[i];

    }

    char[] uniqueChar = new char[j + 1];
    for (int k = 0; k <= j; k++) {
    uniqueChar[k] = str[k];
    }

    String finalString =  new String(uniqueChar);

    if(finalString.length() ==0) {
        return "Empty String";
    } else {
        return finalString;
    }
     

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter a String: ");
        String s = sc.nextLine();

        String result = superReducedString(s);
        
        System.out.println(result);

        
    }

}
