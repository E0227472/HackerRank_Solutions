package com.capgemini.thirtydayscode;

import java.time.LocalDate;
import java.util.Scanner;

public class Day26NestedLogic {

	public static void main(String[] args) {
		// date inputs
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter return day: ");
		int dayReturn = scanner.nextInt();
		int monthReturn = scanner.nextInt();
		int yearReturn = scanner.nextInt();

		scanner.nextLine();

		int dayDue = scanner.nextInt();
		int monthDue = scanner.nextInt();
		int yearDue = scanner.nextInt();

		LocalDate dateReturn = LocalDate.of(yearReturn, monthReturn, dayReturn);
		LocalDate dateDue = LocalDate.of(yearDue, monthDue, dayDue);
		int fine = 0;
		// if book is returned before dueDate or on dueDate itself
		if (dateReturn.isBefore(dateDue) || dateReturn.equals(dateDue)) {
			System.out.println(fine);
		// if book is returned after due date but same month and same year
		} else if (dateReturn.isAfter(dateDue) && dateReturn.getMonthValue() == dateDue.getMonthValue()
				&& dateReturn.getYear() == dateDue.getYear()) {
			int difference = Math.abs(dateReturn.getDayOfMonth() - dateDue.getDayOfMonth());
			fine = 15 * difference;
			System.out.println(fine);
		// if book is returned after due date, same year but different month
		} else if(dateReturn.isAfter(dateDue) && dateReturn.getMonthValue() != dateDue.getMonthValue() 
				&& dateReturn.getYear() == dateDue.getYear()) {
			int difference = Math.abs(dateReturn.getMonthValue() - dateDue.getMonthValue());
			fine = 500 * difference;
			System.out.println(fine);
		// if book is returned after due date, different year
		} else if(dateReturn.isAfter(dateDue) &&  dateReturn.getYear() != dateDue.getYear()) {
			fine = 10000;
			System.out.println(fine);
		}

	}

}
