package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class countTriplets2 {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {

		long cnt = 0;
		Map<Long, Long> map = new HashMap<>();
		Map<Long, Long> rMap = new HashMap<>();
		for (long n : arr) {
			if (n % r == 0) {
				long pre = n / r;// here was the mistake 'enter code here'
				Long cnt2 = rMap.get(pre);
				System.out.println("The cnt2 is : " + cnt2 + " and gp elements: " + pre + " " + n);
				if (cnt2 != null) {
					cnt += cnt2;
					//System.out.println("The cnt is : " + cnt + " and gp elements: " + pre + " " + n);
				}

				Long cnt1 = map.get(pre);
				System.out.println("the cnt1 is: " + cnt1);
				if (cnt1 != null) {
					rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
					//System.out.println("The cnt1 is : " + cnt1 + " and gp elements: " + pre + " " + n );
				}
			}
			map.put(n, map.getOrDefault(n, 0L) + 1);
		}
		return cnt;

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

		long ans = countTriplets(arr, r);

		System.out.println(String.valueOf(ans));

	}

}
