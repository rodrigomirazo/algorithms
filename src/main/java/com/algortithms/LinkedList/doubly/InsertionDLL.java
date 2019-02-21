package com.algortithms.LinkedList.doubly;

public class InsertionDLL {

    static Node head;

    public static void main(String[] args) {

        append(1);
        append(2);
        append(3);
        append(4);
        append(5);

        printReverse();
    }

    static void print() {
        Node last = head;

        System.out.println("Traverse: ");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.next;
        }

    }

    static void printReverse() {
        Node first = head;

        System.out.println("Traverse: ");
        while (first.next != null) {
            System.out.print(first.data + " ");
            first = first.next;
        }

        System.out.println("Traverse: ");
        while (first != null) {
            System.out.print(first.data + " ");
            first = first.prev;
        }

    }

    static void printReverse2() {

        Node node = head;
        Node last = null;

        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
}
