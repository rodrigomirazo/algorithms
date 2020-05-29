package com.algortithms.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.stream.Collectors;

public class LargestTripleProducts {
    public static void main(String[] args) {

        LargestTripleProducts largestTripleProducts = new LargestTripleProducts();
        int[] arr = largestTripleProducts.findMaxProduct(new int[]
                {2, 1, 2, 1, 2});
        //[1, 1, 2, 2, 2]
        //7:      [       ]
        //5:      [       ]
        //4:
        System.out.println(arr);
        //{-1, -1, 56, 56, 140, 140}
    }

    int[] findMaxProduct(int[] arr) {

        //1. locate the 2 reminding values that will be replaced with -1
        //  Store them into a hashTable
        // { originalNumber -> assignment }

        Hashtable<Integer, Integer> asociateTable = new Hashtable<>();
        int[] sortedArray = arr;
        Arrays.sort(sortedArray);

        for (int i = sortedArray.length-1; i >= 0; i--) {
            if(i < 2) {
                //1 & 2 -> -1
                //search for the corresponding arr[i]:
                //when i = 0: arr[0] = 1
                for (int j = 0; j < arr.length; j++) {
                    if(sortedArray[i] == arr[j]) {
                        arr[j] = -1;
                        break;
                    }
                }
            } else {
                int product = sortedArray[i] * sortedArray[i-1] * sortedArray[i-2];
                for (int j = 0; j < arr.length; j++) {
                    if(sortedArray[i] == arr[j]) {
                        //when arr[i] = 7 =>
                        arr[j] = product;
                        break;
                    }
                }
            }
        }

        return arr;
    }
}
