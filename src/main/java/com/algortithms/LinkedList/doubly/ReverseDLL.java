package com.algortithms.LinkedList.doubly;

public class ReverseDLL {

    static Node head;

    public static void main(String[] args) {

        append(1);
        append(2);
        append(3);
        append(4);
        append(5);

        while (head.prev != null) {
            head = head.prev;
        }

        reverseList();

        while (head != null) {
            System.out.print(head.data + "-");
            head = head.prev;
        }


        System.out.println();
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }

    static void reverseList() {
        Node node = head;
        Node temp = null;

        while (node != null) {

            temp = node.prev;
            node.prev = node.next;
            node.next = temp;
            //node.prev is now node.next
            node = node.prev;
        }

        System.out.println();
    }

    static void print() {
        System.out.println("\nprint");

        Node first = head;
        while (first.next != null) {
            System.out.print(first.data + " ");
            first = first.next;
        }

        System.out.println("\n\nPrint Reverse");
        while(first != null) {
            System.out.print(first.data + " ");
            first = first.prev;
        }

    }

    static void append(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node newNode = new Node(new_data);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        newNode.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = newNode;

        /* 7. Make last node as previous of new node */
        newNode.prev = last;
    }

    /* Doubly Linked list Node*/
    static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }


    }
}
