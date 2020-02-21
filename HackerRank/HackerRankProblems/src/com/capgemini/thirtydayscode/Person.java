package com.capgemini.thirtydayscode;

import java.util.Scanner;

public class Person {

	protected String firstName;
	protected String lastName;
	protected int idNumber;

	// Constructor
	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}

}

class Student extends Person {
	private int[] testScores;

	public Student(String firstName, String lastName, int idNumber, int[] testScores) {
		super(firstName, lastName, idNumber);
		this.testScores = testScores;
	}

	public char calculate() {
		char result = '1';
		int avgSum = 0;
		for (int i = 0; i < this.testScores.length; i++) {
			avgSum += testScores[i];
		}
		avgSum = avgSum/this.testScores.length;
		if(avgSum <= 100 && avgSum >= 90)
			result = 'O';
		else if(avgSum < 90 && avgSum >= 80)
			result = 'E';
		else if(avgSum < 80 && avgSum >= 70)
			result = 'A';
		else if(avgSum < 70 && avgSum >= 55)
			result = 'P';
		else if(avgSum < 55 && avgSum >= 40)
			result = 'D';
		else if(avgSum < 40)
			result = 'T';
		
		return result;
		
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
