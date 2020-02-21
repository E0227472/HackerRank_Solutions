package com.datastructures;

import java.util.*;

public class MinimumAbsDiffArray {

    public static void main (String ...args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of input array: ");
        int size = scanner.nextInt();

        int input[] = new int[size];

        //get the array input values
        for(int i = 0; i <size; i++) {
            input[i] = scanner.nextInt();
        }



        int result = absDiff(input);

        System.out.println(result);


    } // end of main method

    public static int absDiff (int [] input) {
        Arrays.sort(input);
        // set initial diff as the largest
        int diff = Integer.MAX_VALUE;
        // in sorted array, any smallest difference between any 2 elements will be next to each other
        for(int i = 0; i< input.length-1; i++) {
           int currentDiff = Math.abs(input[i+1] - input[i]);
            diff = Math.min(diff,currentDiff);
        }

        return diff;
    } // end of absDiff method
}
