package com.algortithms.a.practiceFB.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 6, 2, 10};
        mergeSort(array, new int[array.length], 0, array.length-1);

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    static void mergeSort(int arr[], int temp[], int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (right + left) / 2;

        mergeSort(arr, temp, left, middle);
        mergeSort(arr, temp, middle + 1, right);

        merge(arr, temp, left, right);
    }

    static void merge(int arr[], int temp[], int leftStart, int rightEnd) {

        int indx = leftStart;
        int leftIndx = leftStart;
        int rightIndx = ((rightEnd + leftStart) / 2 ) + 1;

        int leftEnd = (rightEnd + leftStart) / 2;
        int size = rightEnd - leftStart + 1;

        // 10 20 35 15 25 78
        while( leftIndx <= leftEnd && rightIndx <= rightEnd) {
            if(arr[leftIndx] <= arr[rightIndx]) {
                temp[indx] = arr[leftIndx];
                leftIndx++;
            } else {
                temp[indx] = arr[rightIndx];
                rightIndx++;
            }
            indx++;
        }
        //I need to asign the rest of the elements to the temp Array
        System.arraycopy(arr, leftIndx, temp, indx, leftEnd - leftIndx + 1);
        System.arraycopy(arr, rightIndx, temp, indx, rightEnd - rightIndx + 1);

        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }

}
