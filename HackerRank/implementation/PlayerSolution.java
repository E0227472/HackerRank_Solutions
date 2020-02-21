package com.capgemini.implementation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PlayerSolution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the array size for player objects: ");
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();
		System.out.println("Enter the array of player objects: ");
		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}

}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
	// complete this method
	public int compare(Player a, Player b) {
		int c;
		Integer a1 = new Integer(a.score);
		Integer b1 = new Integer(b.score);
		c = b1.compareTo(a1);
		if(c == 0) 
			c = a.name.compareTo(b.name);
		else 
			c = b1.compareTo(a1);
		
		return c;
	}
}
