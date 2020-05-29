package com.algortithms.LinkedList.simple;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListReverseFaceBook {

    static Hashtable<Integer, List<Integer>> indexTable = new Hashtable<>();
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        Node head = null;
        head = LinkedListOrder.persistNode(head, new int[]{2, 18, 24, 3, 5, 7, 9, 6, 12});

        substitudeDAta(head);
        // (24, 18, 2) (12, 6)
        substitudeDAta(head, 0, 0);

        System.out.println("Result: ");
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static boolean isNone(int value) {
        if(value % 2 == 0)
            return false;

        return true;
    }

    static void substitudeDAta(Node head) {

        // 2, 18, 24
        // 6, 12
        if(head == null || isNone(head.data) ) {
            temp = temp.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
            indexTable.put(indexTable.size(), temp);// 2, 18, 24 // next: 6, 12
            temp = new ArrayList<>();

            if(head == null)
                return;

            if( isNone(head.next.data) ) {
                while(head.next != null && isNone(head.next.data))
                    head = head.next;
            }
        } else {
            temp.add(head.data);
        }

        substitudeDAta(head.next);
    }

    static void substitudeDAta(Node head, int tableIndx, int listIndx) {

        if(head == null)
            return;
        // Recursion to iter head

        // 0 -> 2, 18, 24
        // 1 -> 6, 12
        if(isNone(head.data)) {
            listIndx = 0;
            tableIndx++;

            if( isNone(head.next.data) ) {
                while(head.next != null && isNone(head.next.data))
                    head = head.next;
            }

        } else {
            head.data = indexTable.get(tableIndx).get(listIndx);
            listIndx++;
        }

        substitudeDAta(head.next, tableIndx, listIndx);
    }


}
