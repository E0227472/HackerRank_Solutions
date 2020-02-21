package com.capgemini.thirtydayscode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day112DArrays {

	public static void main(String[] args) {
		// row x column
        int[][] arr = new int[][] {{ 1, 1, 1, 0, 0, 0},
        						   { 0, 1, 0, 0, 0, 0},
        						   { 1, 1, 1, 0, 0, 0},
        						   { 0, 0, 2, 4, 4, 0},
        						   { 0, 0, 0, 2, 0, 0},
        						   { 0, 0, 1, 2, 4, 0}};
        int sum = 0;
        List<Integer> sums = new ArrayList<Integer>();
        // loop for columns 				   
        for(int row = 2; row < arr[0].length; row++) {
        	// loop for rows 
        	for(int col = 2; col < arr[1].length; col++) {
        			  // first row elements 
        		sum = arr[row-2][col-2] + arr[row-2][col-1] + arr[row-2][col]
        			  + arr[row-1][col-1] // 2nd row element
        			  + arr[row][col-2] + arr[row][col-1] + arr[row][col]; // 3rd row elements 
        		sums.add(sum);
        	}
        }
        
        int maxSum = Collections.max(sums);
        System.out.println("The maximum sum is:  " + maxSum);

	}

}
