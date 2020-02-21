package com.capgemini.thirtydayscode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28Regex {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		List<String> firstnames = new ArrayList<String>();
		String email = "[a-z]*@gmail\\.com(\\W|$)";
		
		String name = "[a-z]";
		
		Pattern pEmail, pName;
		Matcher mEmail, mName;
		
		

		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");

			String firstName = firstNameEmailID[0];

			String emailID = firstNameEmailID[1];
			// email consists of only lowercase, @ and . and gmail.com
			pEmail = Pattern.compile(email);
			mEmail = pEmail.matcher(emailID);
			// email consists of only lower case 
			pName = Pattern.compile(name);
			mName = pName.matcher(firstName);
			
			if(mName.find() && mEmail.find() && firstName.length() <= 20 && emailID.length() <=50
			   && firstName.equals(firstName.toLowerCase()) && emailID.equals(emailID.toLowerCase()))
				firstnames.add(firstName);
			
			
		}
		
		Collections.sort(firstnames);
		
		for(String output: firstnames) 
			System.out.println("firstnames: " + output);

		scanner.close();

	}

}
