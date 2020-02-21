package com.datastructures;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FullCountingSort {

    public static void main(String ...args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the input array: ");

        int n = scanner.nextInt();

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            arr.add(
                    Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                            .collect(toList())
            );
        });

        countSort(arr);

    }

    public static void countSort(List<List<String>> arr) {

        int stringLength = arr.size();
        int convertStringLength =  stringLength / 2;
        // array of list that stores list type
        String [] strs = new String [stringLength];


        for(int i = 0; i < stringLength; i++) {
            List<String> intStringPair = new ArrayList<>();

            // get the integer / string pair
            intStringPair = arr.get(i);
            // get the integer value for each string
            int intHash = Integer.parseInt(intStringPair.get(0));
            // if pushing first character into string
            if(strs[intHash] == null) {
                strs[intHash] = "";
            }

            // convert the 1st half of input to '-'
            if (i < convertStringLength) {
                strs[intHash]+= "-" + " ";
                //System.out.println(strs[intHash] + " " + intHash );
            }

            else { // if input is second half
                strs[intHash] += intStringPair.get(1) + " ";
                // System.out.println(strs[intHash]+ " " + intHash);
            }

        }// end of for loop

        String result = "";
        for(String value : strs) {
            if(value == null)
                continue;
            else {
                result += value;
                //System.out.println(result +  " " + "final");
            }
        }


        System.out.println(result);
    } // end of countSort method
}
