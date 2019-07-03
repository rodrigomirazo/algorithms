package com.algortithms.LinkedList.simple;

public class LinkedListDelete {

    public static Node head = null;

    public static void main(String[] args) {

        LinkedListDelete linkedList = new LinkedListDelete();

        linkedList = insert(linkedList, 1);
        linkedList = insert(linkedList, 2);
        linkedList = insert(linkedList, 3);
        linkedList = insert(linkedList, 4);
        linkedList = insert(linkedList, 5);

        printLL( linkedList );

        //linkedList = deleteNode(linkedList, 2);
        deleteNode(4);
        printLL(linkedList);

    }

    static void deleteNode(int key) {

        // Store head node
        Node current = head;
        Node prev = null;

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (current != null && current.data != key)
        {
            prev = current;
            current = current.next;
        }

        System.out.println("prev.next = " + prev.next.data);
        System.out.println("current.next = " + current.next.data);

        // Unlink the node from linked list
        prev.next = current.next;
    }

    static LinkedListDelete deleteNode(LinkedListDelete linkedList, int data) {

        if( linkedList.head == null) {
            return linkedList;
        } else {
            Node current = linkedList.head;
            Node temp = null;

            System.out.println("deleteting: ");
            while (current != null) {


                if(current.data != data)
                    current = current.next;
                else {
                    System.out.print(current.data + " ");
                    current.next = current.next.next;
                }
            }
            System.out.println();
        }

        return linkedList;
    }


    static LinkedListDelete insert(LinkedListDelete linkedList, int data) {
        Node newNode = new Node(data);

        if( linkedList.head == null) {
            linkedList.head = newNode;
        } else {

            Node current = linkedList.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        return linkedList;
    }

    static void printLL(LinkedListDelete linkedList) {

        Node node = linkedList.head;
        System.out.println("print: ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

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

}
