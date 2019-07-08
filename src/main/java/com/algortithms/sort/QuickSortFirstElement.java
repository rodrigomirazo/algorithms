package com.algortithms.sort;
/* This function takes last element as pivot,
   places the pivot element at its correct
   position in sorted array, and places all
   smaller (smaller than pivot) to left of
   pivot and all greater elements to right
   of pivot */
public class QuickSortFirstElement {

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
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);

            sort(arr, pi+1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int hight = (high-1);

        for (int i = high; i>low; i--) {
            // If current element is smaller than or
            //System.out.println("arr[j] " + arr[j]);
            // equal to pivot
            if (arr[i] >= pivot) {
                //System.out.println("    arr[j] " + arr[j] + " <= pivot = " + pivot + " && i = " + arr[i+1] + "");
                hight--;
                // swap arr[i] and arr[j]
                int temp = arr[hight];
                arr[hight] = arr[i];
                arr[i] = temp;
                System.out.print(arr[i] + " ");
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[hight+1];
        arr[hight+1] = arr[high];
        arr[high] = temp;

        return hight+1;
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
