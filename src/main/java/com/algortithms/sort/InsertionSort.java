package com.algortithms.sort;

public class InsertionSort {

    static void insertionSortWhile(int n, int[] arr) {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int decrease = i - 1;

            while (decrease >= 0 && arr[decrease] > key) {
                arr[decrease + 1] = arr[decrease];
                decrease = decrease - 1;
            }
            arr[decrease + 1] = key;
        }

        print(arr);
    }

    static void print(int[] arr) {
        System.out.println();
        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 6, 2};
        insertionSortWhile(arr.length, arr);
    }

}
