package com.algortithms.LinkedList.simple;

public class LinkedListService {

    Node head = null;

    /**
     * Simple Node
     */
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

    /**
     * Insert
     *
     * @param linkedList
     * @param data
     * @return
     */
    public static LinkedListService insert(LinkedListService linkedList, int data) {

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

    /**
     * Print
     *
     * @param linkedList
     */
    public static void printLinkedList(LinkedListService linkedList) {
        System.out.print("\nLinkedLsit = [");

        Node head = linkedList.head;

        while (head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
        System.out.print("]\n");
    }

    /**
     * FIll Linked List
     *
     * @return
     */
    public LinkedListService fillLinkedList() {
        LinkedListService linkedList = new LinkedListService();

        linkedList = insert(linkedList, 10);
        linkedList = insert(linkedList, 20);
        linkedList = insert(linkedList, 30);
        linkedList = insert(linkedList, 40);
        linkedList = insert(linkedList, 60);

        printLinkedList(linkedList);

        return linkedList;
    }

    /**
     * FIll Linked List
     *
     * @return
     */
    public LinkedListService fillLinkedList_2() {
        LinkedListService linkedList = new LinkedListService();

        linkedList = insert(linkedList, 15);
        linkedList = insert(linkedList, 25);
        linkedList = insert(linkedList, 35);
        linkedList = insert(linkedList, 45);
        linkedList = insert(linkedList, 65);

        printLinkedList(linkedList);

        return linkedList;
    }

}
