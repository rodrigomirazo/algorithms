package com.algortithms.a.practiceFB.search;

public class BinarySearch {
    public static void main(String[] args) {

        int[] array = new int[]{5, 4, 6, 2, 10};
        binarySearch(new int[array.length], 0, array.length-1, 10);

    }

    static int binarySearch(int arr[], int start, int end, int search) {

        if (end > start)
            return -1;

            int middle = start + (end - start) / 2;

            if (arr[middle] == search)
                return middle;

            if (search < arr[middle]) {
                return binarySearch(arr, start, middle - 1, search);
            } else {
                return binarySearch(arr, middle + 1, end, search);
            }

    }
}
