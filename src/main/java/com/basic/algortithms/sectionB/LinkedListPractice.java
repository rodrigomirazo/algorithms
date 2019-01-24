package com.basic.algortithms.sectionB;

public class LinkedListPractice {

    public static void main(String[] args) {
        /**
         * First Linked List
         */
        int[] data1 = {1,3,5,9};
        LinkedListPractice.Node head1 = new LinkedListPractice.Node(data1[0]); // Head1: value = 0 & Head = null
        for(int count = 1; count < data1.length; count++) //Iterate with {1, 3, ...}
            insertNode(head1,data1[count]);

        System.out.printf("Linked list 1 is : ");
        print(head1);

        /**
         * Second Linked List
         */
        int[] data2 = {2,4,5,6,10};
        LinkedListPractice.Node head2 = new LinkedListPractice.Node(data2[0]);
        for(int count = 1; count < data2.length; count++)
            insertNode(head2,data2[count]);

        System.out.printf("Linked list 2 is : ");
        print(head2);

    }

    public static class Node {
        public int data;
        public MergeLinkedList.Node next;
        public Node(int num) {
            this.data = num;
            this.next = null;
        }
    }

    public static void insertNode(Node node, int data) {

    }

    public static void print(Node node) {

    }

    public static void merge(Node head1, Node head2) {

    }
}
