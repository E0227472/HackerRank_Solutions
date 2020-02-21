package com.datastructures;

import java.util.Arrays;
import java.util.Scanner;

import static com.datastructures.MinimumAbsDiffArray.absDiff;

public class MarcCakeWalk {
    public static void main (String ...args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of input array: ");
        int size = scanner.nextInt();

        int input[] = new int[size];

        //get the array input values
        for(int i = 0; i <size; i++) {
            input[i] = scanner.nextInt();
        }




        long  result = minWalk(input);

        System.out.println(result);


    } // end of main method

    public static long minWalk (int [] input) {

        Arrays.sort(input);
        long sum = 0;
        int powCount = input.length -1;
        // loop through array and multiply highest value to start
        for(int i = 0; i < input.length; i++) {
            sum += input[i] * Math.pow(2,powCount);
            powCount--;
        }
        return sum;
    }

}
