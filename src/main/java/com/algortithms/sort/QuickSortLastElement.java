package com.algortithms.sort;

public class QuickSortLastElement {

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {5, 8, 1, 3, 7, 9, 2};
        int n = arr.length;

        //QuickSortLastElement ob = new QuickSortLastElement();
        //ob.
        sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }

    /* The main function that implements QuickSortLastElement()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int lowestElement = low - 1; // index of smaller element

        for (int i = low; i < high; i++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[i] <= pivot) {
                lowestElement++;
                // swap arr[lowestElement] and arr[i]
                int temp = arr[lowestElement];
                arr[lowestElement] = arr[i];
                arr[i] = temp;
            }
        }

        // swap lowest with Hightest Elements
        int temp = arr[lowestElement+1];
        arr[lowestElement+1] = arr[high];
        arr[high] = temp;

        return lowestElement+1;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


}
