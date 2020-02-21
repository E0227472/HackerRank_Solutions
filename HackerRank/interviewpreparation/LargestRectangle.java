package com.capgemini.interviewpreparation;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

	// Complete the largestRectangle function below.
	static long largestRectangle(int[] h) {
		// stack to store the subarrays into temporarily.
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Long> recAreas = new Stack<Long>();

		// loop from front to back, forming combinations of different subarrays with
		// each element.
		for (int i = 0; i < h.length; i++) {

			for (int j = i; j < h.length; j++) { // loop from i onwards to end array to form combinations
				long maxArea = 0l;
				int minHeight = h[j];
				int lengthArray = 0;
				//heights.clear(); // at end of creating subarray, clear the stack

				for (int k = i; k <= j; k++) { // one subarray formation
					if (minHeight > h[k])
						minHeight = h[k];
					//heights.push(h[k]);
					lengthArray++;
				}

				maxArea = lengthArray * minHeight;
				//System.out.println(heights + " area is: " + maxArea + " min height is : " + minHeight);
				if (recAreas.empty()) { // if the stack for areas empty, push the first area.
					recAreas.push(maxArea);
				} else { // if the stack for areas not empty, compare the area with current. if smaller,
							// replace.
					long preArea = recAreas.peek();
					if (preArea < maxArea) {
						recAreas.pop();
						recAreas.push(maxArea);
					}
				}
				//System.out.println(heights);

			}
		}

		return recAreas.peek();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the value for n, the array size: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] h = new int[n];
		System.out.println("Enter the heights: ");
		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		long result = largestRectangle(h);

		System.out.println(String.valueOf(result));
		scanner.close();
	}

}
