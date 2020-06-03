package com.algortithms.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bin = new BinarySearch();
        int result = bin.binarySearch(new int[]{1,2,3,4,5,6}, 0, 6, 5);
        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        //int milestones_2[] = {3100, 2200, 800, 2100, 1000};

        int milestones_2[] = {800, 1000, 2100, 2200, 3100};

        int[] search = bin.getMilestoneDays(revenues_2, milestones_2);
        System.out.println("result indx = " + Arrays.toString(search));
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

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        //1. Create an array of acumulatd revenus
        int[] acumRevenues = new int[revenues.length];
        int[] reachMilestones = new int[milestones.length];
        int acumRevenue = 0;

        for(int i = 0; i < revenues.length; i ++) {
            acumRevenue += revenues[i];
            acumRevenues[i] = acumRevenue;
            // i = 1 : acumRevenue = 700
            // i = 2 : acumRevenue = 1500
        }
        // acumRevenues we have [10, 30, 60, ...]

        //2. Create a search Algorithm (BinarySearch)

        for(int i = 0; i < milestones.length; i ++) {
            reachMilestones[i] = binarySearch(acumRevenues, 0, acumRevenues.length-1, milestones[i]) + 1;
        }

        return reachMilestones;
    }

}
