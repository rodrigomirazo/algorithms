package com.algortithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class QuickSortLastElement {

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {1, 5, 7, 1};
        sort(arr, 0, arr.length-1);

        System.out.println("sorted array");
        Arrays.stream(arr).forEach(value -> { System.out.print(value + " "); });
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int lowestElement = low - 1; // index of smaller element

        for (int i = low; i < high; i++) {
            // If current element is SMALLER than or EQUAL to pivot
            if (arr[i] <= pivot) {
                lowestElement++;
                swap(arr, lowestElement, i);
            }
        }
        swap(arr, lowestElement+1, high);

        return lowestElement+1;
    }

    static void swap(int[] arrRef, int lowestIndx, int hightesIndx) {
        // arr[lowestIndx] <--> arr[hightesIndx]
        int temp = arrRef[lowestIndx];
        arrRef[lowestIndx] = arrRef[hightesIndx];
        arrRef[hightesIndx] = temp;
    }


}
