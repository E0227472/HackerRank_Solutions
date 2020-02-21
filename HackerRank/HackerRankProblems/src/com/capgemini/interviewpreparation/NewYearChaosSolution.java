package com.capgemini.interviewpreparation;

import java.util.Scanner;

public class NewYearChaosSolution {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
	      
		// logic is if the current integer is bigger than 2 as compared to original number,
		// it has to be swapped more than 2 times so it is chaotic.
		
		// further, the number of swaps is as follows: 
		
		// if the 2 positions away to the left(since can only swap 2 times) is bigger than current value, 
		// it is considered a swap. 
		
		int bribe = 0;
	        boolean chaotic = false;
	        for(int i = 0; i < q.length; i++)
	        {
	            if(q[i]-(i+1) > 2)
	            {              
	                chaotic = true;
	                break;    
	            }
	            for (int j = Math.max(0, q[i]-2); j < i; j++)
	                if (q[j] > q[i])
	                    bribe++;
	        }
	        if(chaotic)
	            System.out.println("Too chaotic");
	        else
	            System.out.println(bribe);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of test cases: ");
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		System.out.println("Enter the array size: ");
		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			System.out.println("Enter the array elements: ");
			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}

}
