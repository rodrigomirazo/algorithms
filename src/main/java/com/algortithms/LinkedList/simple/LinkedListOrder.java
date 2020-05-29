package com.algortithms.LinkedList.simple;

public class LinkedListOrder {

    public static void main(String[] args) {

        Node head = null;
        head = persistNode(head, new int[]{2, 18, 24, 3, 5, 7, 9, 6, 12});

        Node head1 = mergeSort(head);

        printll(head1);
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        //Obtain the 2 middle nodes
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        //Make the next node of middle to null, |---Middle-|
        middle.next = null;

        //Apply merge Sort for the first part
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        //Merge the 2 parts
        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    static Node sortedMerge(Node a, Node b) {
        Node result = null;

        if(a == null) return b;
        if(b == null) return a;

        // Pick EITHER a or b and rcur
        if(a.data > b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    /**
     * Get the Mdille node
     * @param head
     * @return
     */
    static Node getMiddle(Node head) {
        if(head == null)
            return head;

        Node firstPart = head, secondPart = head;

        while(secondPart.next != null && secondPart.next.next != null) {
            firstPart = firstPart.next;
            secondPart = secondPart.next.next;
        }

        return firstPart;
    }

    static Node persistNode(Node head, int[] arr) {
        for (int i : arr) {
            head = insert(head, i);
        }
        return head;
    }

    static Node insert(Node head, int value) {
        if(head == null)
            return new Node(value);
        else
            head.next = insert(head.next, value);

        return head;
    }

    static void printll(Node head) {
        if(head == null)
            return;
        System.out.print(head.data + " ");

        printll(head.next);
    }
}
