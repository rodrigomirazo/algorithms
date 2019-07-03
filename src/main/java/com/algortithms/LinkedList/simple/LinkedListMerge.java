package com.algortithms.LinkedList.simple;

public class LinkedListMerge {

    public static Node head = null;

    public static void main(String[] args) {

        Node linkedList = null;

        linkedList = insert(linkedList, 10);
        linkedList = insert(linkedList, 20);
        linkedList = insert(linkedList, 30);
        linkedList = insert(linkedList, 40);
        linkedList = insert(linkedList, 50);

        Node linkedList2 = null;

        linkedList2 = insert(linkedList2, 15);
        linkedList2 = insert(linkedList2, 25);
        linkedList2 = insert(linkedList2, 35);
        linkedList2 = insert(linkedList2, 45);
        linkedList2 = insert(linkedList2, 55);

        printLL( linkedList );
        printLL( linkedList2 );

        System.out.println("\n\n");
        //linkedList = deleteNode(linkedList, 2);
        Node mergedNode = doMerge(linkedList, linkedList2);

        System.out.println("print LinkedList");

        printLL(mergedNode);
    }

    static Node doMerge(Node list1, Node list2) {
        Node mergeList = null;

        if(list1 == null)
            return list2;
        if(list1 == null)
            return list2;


        if(list1.data <= list2.data) {
            mergeList = list1;
            mergeList.next = doMerge(list1.next, list2);

        } else {
            mergeList = list2;
            mergeList.next = doMerge(list1, list2.next);

        }

        return mergeList;
    }

    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if( head == null) {
            head = newNode;
        } else {

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        return head;
    }

    static void printLL(Node head) {

        Node node = head;
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
