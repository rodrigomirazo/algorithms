package com.basic.algortithms.sectionA;

import java.io.*;
import java.util.*;

public class BigSum {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (int i = 0; i <= ar.length - 1; i++) {
            sum += ar[i];
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        long[] ar = {10000001, 10000002,10000003,10000004,10000005};

        long result = aVeryBigSum(ar);


        System.out.println(result);
    }
}