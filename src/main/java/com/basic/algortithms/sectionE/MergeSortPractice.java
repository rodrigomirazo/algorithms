package com.basic.algortithms.sectionE;

public class MergeSortPractice {
    public int[] inputArray = {5, 8, 1, 3, 7, 9, 2};
    public int[] tempMergArr = new int[inputArray.length];
    public int length;

    public static void main(String a[]) {

        int[] inputArr = {5, 8, 1, 3, 7, 9, 2};
        MergeSortPractice mms = new MergeSortPractice();
        mms.sort();
    }

    void sort() {

        merge(0, inputArray.length - 1);
        for (int i = 0; i < inputArray.length; i++)
            System.out.print(inputArray[i] + " ");
    }

    void merge(int lowerIndex, int higherIndex) {
        if( lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex-lowerIndex)/2;

            merge(lowerIndex, middle);
            merge(middle + 1, higherIndex);

            mergeParts(lowerIndex, middle, higherIndex);
        }

    }

    void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++)
            tempMergArr[i] = inputArray[i];

        /* Dynamic index section */
        int leftMiddle = lowerIndex;
        int middleRight = middle + 1;
        int leftRight = lowerIndex;

        //
        while (leftMiddle <= middle && middleRight <= higherIndex) {
            if(tempMergArr[leftMiddle] <= tempMergArr[middleRight]) {
                inputArray[leftRight] = tempMergArr[leftMiddle];
                leftMiddle++;
            } else {
                inputArray[leftRight] = tempMergArr[middleRight];
                middleRight++;
            }
            leftRight++;
        }

        while (leftMiddle <= middle) {
            inputArray[leftRight] = tempMergArr[leftMiddle];
            leftRight++;
            leftMiddle++;
        }
    }

}
