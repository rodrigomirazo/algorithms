package com.algortithms.linkedList;

import java.io.IOException;

public class LinkedListInsert {

    //Declare Linked List class
    Node head = null;

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            //Initialize data
            this.data = data;
            //Set to null next node;
            this.next = null;
        }
    }

    /*
        Demonstration
     */
    public static void main(String[] args) throws IOException {

        LinkedListInsert linkedList = new LinkedListInsert();

        linkedList = insertNode(linkedList, 3);
        linkedList = insertNode(linkedList, 4);
        linkedList = insertNode(linkedList, 5);

        printLinkedList(linkedList);
    }

    /*
        Insert Node
     */
    public static LinkedListInsert insertNode(LinkedListInsert linkedList, int data) {

        //Declare Head List
        Node newHead = new Node(data);

        if( linkedList.head == null ) {
            linkedList.head = newHead;

        } else {

            //Iterate List unitl the last Node
            Node iterate = linkedList.head;
            while (iterate.next != null) {
                iterate = iterate.next;
            }

            iterate.next = newHead;
        }

        return linkedList;
    }

    /*
        Print Node
     */
    public static void printLinkedList(LinkedListInsert linkedList) {

        Node iterate = linkedList.head;
        while (iterate != null) {
            System.out.println(" " + iterate.data);
            iterate = iterate.next;
        }
    }

}
