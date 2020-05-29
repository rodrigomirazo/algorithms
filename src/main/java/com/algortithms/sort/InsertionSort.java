package com.algortithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        int[] states = {1, 3, 5, 7};
        List<List<Integer>> files = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);

        files.add( arr );
        files.add(arr);
        files.add(arr);
        files.add(arr);


    }



    public static int getMax(List<List<Integer>> Lists) {

        int max = 0;
        int i = 0;
        while (i < Lists.size()) {
            i++;

            if( Lists.get(i-1)
                    .get(1) > max )
                max = Lists.get(i).get(1);
        }

        return max;
    }
}
