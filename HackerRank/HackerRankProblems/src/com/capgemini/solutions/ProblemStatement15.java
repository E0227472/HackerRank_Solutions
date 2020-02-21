package com.capgemini.solutions;

import java.util.Scanner;

public class ProblemStatement15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get string input
		System.out.println("Enter value for String: ");
		String s = sc.next();
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int countOpen = 0;
		int countClose = 0;
		String s1 = null;
		String s2 = null;
		int kk = 0;
		for (int i = 1; i < s.length(); i++) {
			countOpen = 0;
			countClose =0;
			s1 = s.substring(0, i);
			 s2 = s.substring(i);
			for(int j = 0; j < s1.length(); j++) {
				if(s1.charAt(j) == '(') {
					countOpen++;
				}	
			}
			
			for(int k = 0; k < s2.length(); k++) {
				if(s2.charAt(k) == ')') {
					countClose++;
				}	
			}
			
			if(countOpen == countClose) {
				kk = i;
				break;
			} 
			
		}
		return kk;
	}

}
