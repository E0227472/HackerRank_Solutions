package com.capgemini.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemStatement8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//get range of N
		System.out.println("Enter value for N: ");
		int N = Integer.parseInt(sc.next());
		System.out.println("Enter size of array: ");
		int size = Integer.parseInt(sc.next());
		int [] A = new int[size];
		System.out.println("Enter values for the array");
		for(int i = 0; i <A.length; i++) {
			A[i] = Integer.parseInt(sc.next());
		}

		System.out.println(solution(A));
	}

	public static int solution(int [] A) {
		int minSum = 0;
		ArrayList<Integer> B = new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) {
			for(int j=i; j<A.length; j++) {
				minSum += A[j];
				System.out.println("("+ i + "," + j + ")" + " = " + Math.abs(minSum));
				 B.add(Math.abs(minSum));
			}
		}
		
		return Collections.min(B);
	}

	
}
