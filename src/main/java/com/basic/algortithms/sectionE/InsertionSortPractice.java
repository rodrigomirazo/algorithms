package com.basic.algortithms.sectionE;

public class InsertionSortPractice {


    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 6, 2};
        insertionSort(arr.length, arr);
        print(arr);
    }

    static void insertionSort(int n, int[] arr) {

    }

    static void print(int[] arr) {
        System.out.println();
        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
