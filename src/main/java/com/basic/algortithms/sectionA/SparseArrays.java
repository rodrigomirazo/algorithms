package com.basic.algortithms.sectionA;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        //Action Plan: take 2 cicles inner & outer
        int strCounter = 0;
        int[] resultArray = new int[queries.length];
        //a) outer stays for the queries Array
        for (int i = 0; i < queries.length; i++ ) {
            // -> every iteration will take a query, initialize a counter
            strCounter = 0;
            //b) inner stays for the strings Array
            for (int j = 0; j < strings.length; j++ ) {
                // -> consider the current queri[i] comparing for each string
                // if there´s a coincidence counter will increa
                if( queries[i].equalsIgnoreCase( strings[j] ) ) {
                    // at the and of the iteration counter will be store in a resultArray
                    strCounter++;
                }
            }
            resultArray[i] = strCounter;
        }

        return resultArray;
    }

    public static void main(String[] args) {

        String[] strings = {"def", "de", "fgh"};
        String[] queries = {"de", "lmn", "fgh"};

        int[] resultArray = matchingStrings(strings, queries);

        for (int i = 0; i < resultArray.length; i++) {
            System.out.println( resultArray[i] + " ");
        }
    }
}
