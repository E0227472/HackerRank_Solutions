package com.capgemini.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger fac = new BigInteger("1");
		for(int i=2;i<=n;++i){
			fac= fac.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(fac);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the value to calculate the factorial from: ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		extraLongFactorials(n);

		scanner.close();
	}

}
