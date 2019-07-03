package com.algortithms.search;

public class BinarySearch {

    int binarySearch(int arr[], int start, int end, int x) {
        // Variables
        if (end >= start) {
            int mid = start + (end - start) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, start, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, end, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

}
