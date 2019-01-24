package com.basic.algortithms.sectionG;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SnakeLadders {
    static int quickestWayUp(int[][] ladders, int[][] snakes) {

        Queue<Integer> queue = new LinkedList<>();
        //the Chosen path will be marked using a queue
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(1, 0);
        queue.add(1);

        while(!queue.isEmpty()) {
            //element: begin position
            Integer element = queue.remove();
            if (element == 100) {
                //we win!!
                return visited.get(100);
            }
            //every dice posibility
            for (Integer i = 1; i <= 6; i++) {
                Integer pos = i + element;

                if (contain(ladders, pos)) {
                    pos = getLadSnakPos(ladders, pos);

                } else if (contain(snakes, pos)) {
                    pos = getLadSnakPos(snakes, pos);
                }

                System.out.println("\n\nelement = " + element);
                System.out.println(" visited.get(element) = " + visited.get(element));

                if (visited.get(pos) == null) {
                    visited.put(pos, visited.get(element) + 1);
                    queue.add(pos);

                    //if the visited is not null AND
                } else if (visited.get(element) + 1 < visited.get(pos)) {

                    System.out.println("visited.get(element)+1 = " + (visited.get(element) + 1) +
                                        "visited.get(pos) = " + visited.get(pos));
                    visited.put(pos, visited.get(element + 1));
                }

            }
        }

        return -1;
    }

    public static int getLadSnakPos(int[][] laddSnake, int pos) {
        for(int i = 0; i < laddSnake.length; i++) {
            if(laddSnake[i][0] == pos)
                return laddSnake[i][1];
        }
        System.out.println("getPos not found");
        return -1;
    }

    public static boolean contain(int[][] laddSnake, int pos) {
        for(int i = 0; i < laddSnake.length; i++) {
            if(laddSnake[i][0] == pos)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] ladders = new int[4][2];
        int[][] snakes = new int[9][2];

        ladders[0][0] = 32;
        ladders[0][1] = 62;
        ladders[1][0] = 42;
        ladders[1][1] = 68;
        ladders[2][0] = 12;
        ladders[2][1] = 98;

        snakes[0][0] = 95;
        snakes[0][1] = 13;
        snakes[1][0] = 97;
        snakes[1][1] = 25;
        snakes[2][0] = 93;
        snakes[2][1] = 37;
        snakes[3][0] = 79;
        snakes[3][1] = 27;
        snakes[4][0] = 75;
        snakes[4][1] = 19;
        snakes[5][0] = 49;
        snakes[5][1] = 47;
        snakes[6][0] = 67;
        snakes[6][1] = 17;

        int result = quickestWayUp(ladders, snakes);
        System.out.println("first test case: " + result);


        snakes[0][0] = 51;
        snakes[0][1] = 19;
        snakes[1][0] = 39;
        snakes[1][1] = 11;
        snakes[2][0] = 37;
        snakes[2][1] = 29;
        snakes[3][0] = 81;
        snakes[3][1] = 3;
        snakes[4][0] = 59;
        snakes[4][1] = 5;
        snakes[5][0] = 79;
        snakes[5][1] = 23;
        snakes[6][0] = 53;
        snakes[6][1] = 7;
        snakes[7][0] = 43;
        snakes[7][1] = 33;
        snakes[8][0] = 77;
        snakes[8][1] = 21;

        ladders[0][0] = 8;
        ladders[0][1] = 52;
        ladders[1][0] = 6;
        ladders[1][1] = 80;
        ladders[2][0] = 26;
        ladders[2][1] = 42;
        ladders[3][0] = 2;
        ladders[3][1] = 72;

        result = quickestWayUp(ladders, snakes);
        System.out.println("Secind test case: " + result);
    }
}
