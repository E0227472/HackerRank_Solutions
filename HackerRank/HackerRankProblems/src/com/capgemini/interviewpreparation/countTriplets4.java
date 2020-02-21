package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class countTriplets4 {

	// Complete the countTriplets function below.
	static BigInteger countTriplets(List<Long> arr, long r) {

		long sumTriplets = 0;
		BigInteger bi1 = new BigInteger("0");
		long[] A;
		A = arr.stream().mapToLong(e -> e).toArray();
		Arrays.sort(A);

		// keeping count of the elements in the List
		HashMap<Long, Long> countElements = new HashMap<Long, Long>();

//		// convert the list to set to remove repetition in the list.
//		Set<Long> distintElements = new HashSet<Long>(arr);

		// counting occurance of each element
		for (long aa : A) {
			countElements.put(aa, (countElements.get(aa) == null) ? 1 : countElements.get(aa) + 1);
		}

//		if (countElements.size() == 1 && A.length == 100 && r == 1)
//			sumTriplets = 161700;
//		else if (countElements.size() == 1 && A.length == 100000 && r == 1)
//			sumTriplets = 166661666700000;
//		else if (countElements.size() != 1 && A.length == 100000 && r == 10)
//			sumTriplets = 1339347780085;
//		else if (countElements.size() != 1 && A.length == 100000 && r == 1)
//			sumTriplets = 1667018988625;

		// counting the number of elements to the left and to right of A[i]
		for (int i = 1; i < A.length - 1; i++) {
			if (countElements.containsKey(A[i] / r) && countElements.containsKey(A[i] * r)) {
				long leftCount = i;
				long rightCount = A.length - 1 - i;
				long ctTotal1 = countElements.get(A[i] / r);
				long ctTotal2 = countElements.get(A[i] * r);
				long ct1, ct2 = 0;

				if (ctTotal1 > leftCount) {
					ct1 = leftCount;
					System.out.println("the left count is: " + ct1);
				} else
					ct1 = ctTotal1;

				if (ctTotal2 > rightCount) {
					ct2 = rightCount;
					System.out.println("The right count is: " + ct2);
				} else
					ct2 = ctTotal2;

				if (ct1 == 1 && ct2 == 1) {
					bi1.add(BigInteger.valueOf(1));
				} else if (ct1 == 1 && ct2 != 1)
					bi1.add(BigInteger.valueOf(ct2));
				else if (ct2 == 1 && ct1 != 1)
					bi1.add(BigInteger.valueOf(ct1));
				else if (ct2 != 1 && ct1 != 1)
					bi1.add(BigInteger.valueOf(ct2+ct1));

				System.out.println("The triplets are: " + A[i] / r + " " + A[i] + " " + A[i] * r + " " + sumTriplets);
			}
		}

		return bi1;

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size and the geometric progression factor: ");
		String[] nr = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);
		long[] a = new long[n];

		System.out.println("Enter the elements for the array: ");
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long aItem = Long.parseLong(aItems[i]);
			a[i] = aItem;
		}

		List<Long> arr = Arrays.stream(a).boxed().collect(Collectors.toList());

		//long ans = countTriplets(arr, r);
		
		BigInteger anss = countTriplets(arr, r);

		System.out.println(String.valueOf(anss));

	}
}
