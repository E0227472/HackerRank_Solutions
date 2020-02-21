package com.capgemini.compete;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BusyDays {

	// Complete the solve function below.
	static String solve(List<List<String>> reservations) {
		Map<String, Integer> countDates = new HashMap<String, Integer>();
		for (List<String> ele : reservations) {
			for (String date : ele) {
				countDates.put(date, (!countDates.containsKey(date)) ? 1 : countDates.get(date) + 1);
			}
		}

		String maxDate = "";
		int maxValue = 0;

		String currentDate = null;
		int currentValue = 0;

		// looping through the map
		for (Map.Entry<String, Integer> val : countDates.entrySet()) {
			currentValue = val.getValue(); // getting current value
			currentDate = val.getKey(); // getting current key
			// System.out.println("CurrentDate is :" + currentDate);

			if (maxDate != "") { // if value already initiated

				if (currentValue > maxValue) { // if current bigger than maximum
					maxValue = currentValue;
					maxDate = currentDate;
				}

				else if (currentValue == maxValue) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

					Date date1 = null;
					try {
						date1 = format.parse(maxDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date date2 = null;
					try {
						date2 = format.parse(currentDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (date2.compareTo(date1) < 0) {
						maxDate = currentDate;
					}
				}

			} else {
				maxDate = val.getKey();
				maxValue = val.getValue();
			}
		}

		return maxDate;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of test cases: ");
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			System.out.println("Enter the number of reservations: ");
			int n = Integer.parseInt(scanner.nextLine().trim());
			// reservations consists of several lists. Each list consists of the 2 dates.
			List<List<String>> reservations = new ArrayList<>();

			IntStream.range(0, n).forEach(i -> {
				// System.out.println("Enter the reservation dates: ");
				reservations.add(
						Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).collect(Collectors.toList()));
			});

			String result = solve(reservations);

			System.out.println(result);
		});
		scanner.close();
	}

}
