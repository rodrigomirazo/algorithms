package com.algortithms.LinkedList.simple;

public class ReverLinkedList {
    static Node head = null;

    public static void main(String[] args) {

        //Fill Linked List
        head = persistNode(head, new int[]{2, 18, 24, 3, 5, 7, 9, 6, 12});
        head = reverseNode(head);

        System.out.println("Verify:");
        printLL(head, new int[]{24, 18, 2, 3, 5, 7, 9, 12, 6}, 0);
    }

    static Node persistNode(Node head, int[] arr) {
        for (int i : arr) {
            head = insert(head, i);
        }

        return head;
    }

    static boolean isNone(int value) {
        int i = value % 2;
        if(i == 0)
            return false;

        return true;
    }

    // Deletes k-th node and returns new header.
    static Node reverseNode(Node head) {

        if (head == null )
            return head;

        if ( !isNone(head.data) ) {
            Node post = reverseNode(head.next.next);
            Node res = head.next;

            res.next = head;

            head.next = post;
            return res;
        } else {
            head.next = reverseNode(head.next);

            return head;
        }

    }

    static Node deleteNode(Node head, int value) {
        // If linked list is empty
        if (head == null)
            return null;

        // Base case (start needs to be deleted)
        if (head.data == value) { // value = 3

            // new Node(4) (ignore 3)
            Node res = head.next;
            return res;
        }

        head.next = deleteNode(head.next, value);
        return head;
    }

    static Node insert(Node head, int value) {
        if (head == null)
            return new Node(value);

        head.next = insert(head.next, value);
        return head;
    }

    static void printLL(Node head, int[] output, int count) {
        if(head == null)
            return;

        System.out.println(head.data + " - " + output[count++] );
        printLL(head.next, output, count);
    }
}
