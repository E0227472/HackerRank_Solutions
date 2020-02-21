package com.capgemini.compete;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MinimumTimeRequired2 {

	// Complete the minTime function below.
	static long minTime(long[] machines, long goal) {
		Arrays.sort(machines);
		long maxtime = machines[machines.length - 1];
		long maxPossibleTime = maxtime * goal;

		// hashmap to calcuate the frequence of each element in the array
		Map<Long, Long> taskCompletedOneDay = new TreeMap<Long, Long>();

		for (long k : machines) {
			taskCompletedOneDay.put(k, (!taskCompletedOneDay.containsKey(k)) ? 1 : taskCompletedOneDay.get(k) + 1);
		}
	
		long lowPossibleTime = 1;
		long highPossibletime = maxPossibleTime;
		long numberItemsCreated = 0;
		long midPossibleTime = 0;
		boolean exitLoop = false;
		while (exitLoop == false) {
			 midPossibleTime = lowPossibleTime + highPossibletime >>1;
			 
			numberItemsCreated = 0;
			for (Map.Entry<Long, Long> val : taskCompletedOneDay.entrySet()) {
				long day = val.getKey();
				numberItemsCreated += val.getValue() * (midPossibleTime / day);
			}
			System.out.println(numberItemsCreated + " : items created " + midPossibleTime + " : time required");
			if (numberItemsCreated > goal) {
				highPossibletime = midPossibleTime;
			} else if (numberItemsCreated < goal) {
				lowPossibleTime = midPossibleTime +1;
			} else 
				exitLoop = true;
		}

		return midPossibleTime;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of machines and the goal respectively: ");
		String[] nGoal = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nGoal[0]);

		long goal = Long.parseLong(nGoal[1]);

		long[] machines = new long[n];
		System.out.println("Enter array elements: ");
		String[] machinesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long machinesItem = Long.parseLong(machinesItems[i]);
			machines[i] = machinesItem;
		}

		long ans = minTime(machines, goal);

		System.out.println(String.valueOf(ans));

		scanner.close();
	}

}
