package com.capgemini.compete;

import java.util.Arrays;
import java.util.Scanner;

public class ExamRush {

	static int examRush(int[] tm, int t) {
		// Complete this function
		int hours = 0;
		int chapters = 0;
		Arrays.sort(tm);
		for(int i = 0; i < tm.length; i++) {
			hours += tm[i];
			if(hours <= t)
				chapters++;
			else 
				break;
		}
		
		return chapters;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter values for n and t respectively: ");
		// n: total number of chapters
		int n = in.nextInt();
		// t: total number of hours before the exam 
		int t = in.nextInt();
		System.out.println("Enter the array of hours required for each chapter: ");
		int[] tm = new int[n];
		// Array of hours required for each chapter 
		for (int tm_i = 0; tm_i < n; tm_i++) {
			tm[tm_i] = in.nextInt();
		}
		int result = examRush(tm, t);
		System.out.println(result);
		in.close();
	}

}
