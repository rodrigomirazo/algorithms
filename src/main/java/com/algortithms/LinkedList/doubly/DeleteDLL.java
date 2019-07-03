package com.algortithms.LinkedList.doubly;

public class DeleteDLL {

    static Node head;

    public static void main(String[] args) {

        append(1);
        append(2);
        append(3);
        append(4);
        append(5);
        append(6);
        append(7);

        System.out.println("print Recursive: node.data = ");
        printRecursive(head);
        System.out.println();

        deleteWhile(3);
        head = deleteRecursive(head, 4);

        System.out.println("\n\nprint Recursive");
        printRecursive(head);
    }

    static Node deleteRecursive(Node node, int data) {

        if(node == null)
            return node;

        if(node.data == data) {

            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        deleteRecursive(node.next, data);

        return node;
    }

    static void deleteWhile(int data) {

        Node node = head;

        while (node != null) {

            if(node.data == data) {
                System.out.print("\n" + "data=" + data + "\n");

                node.next.prev = node.prev;
                node.prev.next = node.next;
            }

            node = node.next;
        }

    }

    static void printRecursive(Node head) {

        if(head == null)
            return;

        System.out.print(head.data + " ");

        printRecursive(head.next);
    }

    static void print() {
        Node first = head;
        System.out.println();
        while (first != null) {
            System.out.print(first.data + " ");
            first = first.next;
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
