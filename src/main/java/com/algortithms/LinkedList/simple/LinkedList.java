package com.algortithms.LinkedList.simple;

public class LinkedList {

    public static Node head = null;

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);

        printLL( linkedList.head );

        //linkedList = deleteNode(linkedList, 2);
        deleteNode(linkedList.head, 4);
        printLL(linkedList.head );

    }

    static void deleteNode(Node head, int key) {

        // Store head node
        Node temp = head;
        Node prev = null;

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        //System.out.println("prev.next = " + prev.next.data);
        //System.out.println("current.next = " + current.next.data);

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    static LinkedList deleteNode(LinkedList linkedList, int data) {

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


    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if( head == null) {
            head = newNode;
        } else {

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        return head;
    }

    static void printLL(Node head) {

        Node temp = head;
        System.out.println("print: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
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
