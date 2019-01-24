package com.basic.algortithms.sectionB;

public class MergeLinkedListPractice {

    public static class Node {
        int data;
        Node next;

        Node(int num) {
            this.data = num;
            this.next = null;
        }
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
        Node head1 = new Node(data1[0]);
        for(int count = 1; count < data1.length; count++)
            insert(head1, data1[count]);

        System.out.println("\nLinked list 1 is : ");
        print(head1);

        /**
         * Second Linked List
         */
        int[] data2 = {2,4,5,6,10};
        Node head2 = new Node(data2[0]);
        for(int count = 1; count < data2.length; count++)
            insert(head2,data2[count]);

        System.out.println("\nLinked list 2 is : ");
        print(head2);

        /**
         * Brgin Merge
         */
        Node mergedList = merge(head1, head2);

        System.out.println("\n\nMerged Linked list is : ");

        //Print Merge
        print(mergedList);
    }

    public static void insert(Node head, int data) {
        while(head.next != null)
            head = head.next;

        head.next = new Node(data);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node merge(Node head1, Node head2) {
        Node mergeList = null;

        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        if(head1.data < head2.data) {
            mergeList = head1;
            mergeList.next = merge(head1.next, head2);
        } else {
            mergeList = head2;
            mergeList.next = merge(head1, head2.next);
        }

        return mergeList;
    }

}
