package com.capgemini.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JumpingClouds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {

		List<Integer> indexs = new ArrayList<Integer>();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == 0) {
				indexs.add(i);
			}
		}

		int[] indexArray;
		indexArray = indexs.stream().mapToInt(i -> i).toArray();

		for (int aa : indexArray)
			System.out.println("The indexes are: " + aa);

		int indexLenght = indexArray.length;
		int previousNum = indexArray[0];

		int count = 0;
		// count even consequtive numbers
		for (int i = 2; i < indexArray.length; i += 2) {
			if (indexArray[i] == (indexArray[i-2] + 2)) {
				count++;
			}
		}

		int jumps = indexLenght - count - 1;

		return jumps;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter the size of the array: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		System.out.println("Enter array elements: ");
		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		System.out.println(result);

		scanner.close();
	}

}
