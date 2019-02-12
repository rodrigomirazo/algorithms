package com.algortithms.LinkedList.simple;

public class MergeLinkedList {

    public static class Node {
        public int data;
        public Node next;
        public Node(int num) {
            this.data = num;
            this.next = null;
        }
    }

    public static Node merge(Node head1, Node head2) { // case: head1 -> 1, head2 -> 2
        Node mergedList = null; //create an empty node
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        //point to smaller element
        if(head1.data < head2.data) {
            //assign head 1 to the mergeList
            mergedList = head1;

            //now process next node of head1
            mergedList.next = merge(head1.next, head2);

        //point to Bigger element
        } else {
            //assign head 2 to the mergeList
            mergedList = head2;

            //now process next node of head2
            mergedList.next = merge(head1, head2.next);
        }
        return mergedList;
    }

    /**
     * This is the main Method, let it be test!
     * @param args
     */
    public static void main( String[] args )
    {
        /**
         * First Linked List
         */
        int[] data1 = {1,3,5,9};
        Node head1 = new Node(data1[0]); // Head1: value = 0 & Head = null
        for(int count = 1; count < data1.length; count++) //Iterate with {1, 3, ...}
            insert(head1,data1[count]);

        System.out.printf("Linked list 1 is : ");
        print(head1);

        /**
         * Second Linked List
         */
        int[] data2 = {2,4,5,6,10};
        Node head2 = new Node(data2[0]);
        for(int count = 1; count < data2.length; count++)
            insert(head2,data2[count]);

        System.out.printf("Linked list 2 is : ");
        print(head2);

        /**
         * Second Linked List
         */
        int[] data3 = {1, 13, 14};
        Node head3 = new Node(data3[0]);
        for(int count = 1; count < data3.length; count++)
            insert(head3, data3[count]);

        System.out.printf("Linked list 3 is : ");
        print(head3);

        /**
         * Brgin Merge
         */
        Node mergedList = merge(head1, head2);
        mergedList = merge(head2, head3);

        System.out.printf("Merged Linked list is : ");

        //Print Merge
        print(mergedList);
    }

    public static void insert(Node head, int data) {

        while(head.next != null)
            head = head.next;

        head.next = new Node(data);
    }

    public static void print(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


}
