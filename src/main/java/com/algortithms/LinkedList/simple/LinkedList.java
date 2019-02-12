package com.algortithms.LinkedList.simple;

public class LinkedList {

    // head of list
    static SimpleNode head1;
    static SimpleNode head2;

    static LinkedListService linkedListServ = new LinkedListService();

    public static void main(String[] args) {

        //SimpleList 1
        head1 = linkedListServ.fillLinkedList_1();
        //head2 = linkedListServ.fillLinkedList_2();

    }
}

