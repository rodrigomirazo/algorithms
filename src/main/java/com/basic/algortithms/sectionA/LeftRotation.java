package com.basic.algortithms.sectionA;

public class LeftRotation {

    public static void leftRotation(int n, int d, int[] a) {

        //outter iteration will go through every rotation 'd'
        for (int i = 0; i < d; i++) {

            //get the first element of the array: firstElement = 1
            int firstElement = a[0];
            //System.out.println("firstElement = " + firstElement + "<-");

            //create a temp array, copying the rest of the elements
            //from the second to the end
            int[] tempArray = new int[a.length];  //array of 5 elements
            for( int k = 1; k < (a.length) ; k++) // temp = {2, 3, 4, 5, null}
            {
                tempArray[k-1] = a[k];
            }
            //add the first element at the end
            tempArray[a.length - 1] = firstElement; // temp = {2, 3, 4, 5, 1}

            //replace the tempArray with the original
            a = tempArray;
        }

        for (int j = 0; j < a.length; j++)
            System.out.print(a[j] + " ");
    }

    public static void main(String[] args) {
        String[] nd = {"1", "2", "3", "4", "5"};

        int n = nd.length;
        int d = 4;

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(nd[i]);
            a[i] = aItem;
        }
        leftRotation(n, d, a);

    }
}
