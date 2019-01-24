package com.basic.algortithms.sectionE;

public class QuickSortLastElementPractice {

    // Driver program
    public static void main(String args[]) {
        int arr[] = {5, 8, 1, 3, 7, 9, 2};
        sort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int lowestIndx = (low - 1);

        for (int i = low; i < high; i++) {
            if(arr[i] <= pivot) {
                lowestIndx++;
                //swap arr[i] <-> arr[lowest]
                int temp = arr[lowestIndx];
                arr[lowestIndx] = arr[i];
                arr[i] = temp;
            }
        }

        //swap arr[lowest] <-> arr[high]
        int temp = arr[lowestIndx+1];
        arr[lowestIndx + 1] = arr[high];
        arr[high] = temp;

        return lowestIndx + 1;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        for (int i=0; i < arr.length; ++i)
            System.out.print(arr[i]+" ");
    }

}
