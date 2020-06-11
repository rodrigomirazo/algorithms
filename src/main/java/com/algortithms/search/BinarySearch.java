package com.algortithms.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bin = new BinarySearch();
        int result = bin.binarySearch(new int[]{1,2,3,4,5,6}, 0, 6, 5);

        System.out.println("result indx = " + result);
    }
    int binarySearch(int arr[], int start, int end, int milestoneValue) {
        // Variables
        if (end >= start) {
            int reachMilestone = start + (end - start) / 2;

            // If the element is present at the
            // middle itself
            if (arr[reachMilestone] == milestoneValue)
                return reachMilestone;

            //if (milestoneValue > arr[reachMilestone] && milestoneValue < arr[reachMilestone+1] )
            //    return reachMilestone + 1;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[reachMilestone] > milestoneValue)
                return binarySearch(arr, start, reachMilestone - 1, milestoneValue);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, reachMilestone + 1, end, milestoneValue);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

}
