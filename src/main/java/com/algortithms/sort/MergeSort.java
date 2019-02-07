package com.algortithms.sort;

public class MergeSort {
    private int[] inputArray;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]){

        int[] inputArr = {5, 8, 1, 3, 7, 9, 2};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int inputArr[]) {
        this.inputArray = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the inputArray
            System.out.print("\nFirst Part: ");
            doMergeSort(lowerIndex, middle);

            // Below step sorts the right side of the inputArray
            System.out.print("\nSecond Part: ");
            doMergeSort(middle + 1, higherIndex);

            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = inputArray[i];
        }
        //From lower to the middle
        int leftMiddle = lowerIndex;

        //from the middle to the higher index
        int middleRight = middle + 1;

        //From begining to the end
        int leftRight = lowerIndex;

        //merge from middle to the last
        while (leftMiddle <= middle && middleRight <= higherIndex) {

            if (tempMergArr[leftMiddle] <= tempMergArr[middleRight]) {
                inputArray[leftRight] = tempMergArr[leftMiddle];
                leftMiddle++;
            } else {
                inputArray[leftRight] = tempMergArr[middleRight];
                middleRight++;
            }
            leftRight++;
        }

        //merge from lower to middle
        while (leftMiddle <= middle) {
            System.out.print(tempMergArr[leftMiddle] + " ");
            inputArray[leftRight] = tempMergArr[leftMiddle];
            leftRight++;
            leftMiddle++;
        }

        System.out.println("print Part: ");
        for(int l:tempMergArr){
            System.out.print(" " + l);
        }

    }
}
