package com.algortithms.sort;

import java.util.Arrays;

public class BucketSort {

    public static void main(String[] args) {

        int [] data= {5, 3, 7, 9, 1}; // => 1, 3, 5, 7, 9
        int maxVal = getMax(data);

        System.out.println("Before: " + Arrays.toString(data));
        sort(data,maxVal);
        System.out.println("After:  " + Arrays.toString(data));
    }

    public static void sort(int[] arr, int maxVal) {
        int [] bucket = new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i < arr.length; i++) {
            int aIndx = arr[i];
            bucket[aIndx]++;
        }

        int outPos=0;
        for (int i=0; i < bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                arr[outPos++]=i;
            }
        }
    }

    static int getMax(int arr[]) {

        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
}
