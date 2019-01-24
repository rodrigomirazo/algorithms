package com.basic.algortithms.sectionE;

public class QuickSortFirstElement {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = (high-1); // index of smaller element
        System.out.print("\n pivot = " + pivot + " -> ");
        for (int j = high; j>low; j--) {
            // If current element is smaller than or
            //System.out.println("arr[j] " + arr[j]);
            // equal to pivot
            if (arr[j] >= pivot) {
                //System.out.println("    arr[j] " + arr[j] + " <= pivot = " + pivot + " && i = " + arr[i+1] + "");
                i--;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.print(arr[j] + " ");
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    /* The main function that implements QuickSortLastElement()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);

            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

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

}
