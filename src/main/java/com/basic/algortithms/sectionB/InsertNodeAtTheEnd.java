package com.basic.algortithms.sectionB;

import java.io.IOException;

public class InsertNodeAtTheEnd {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        //case head = null

        //Plan to insert one node at the and of the linked list
        if( head == null) {
            System.out.println("in Null: head = " + new SinglyLinkedListNode(data).data);
            return new SinglyLinkedListNode(data);
        } else {
            //case: head: { data: n, next: head+1}
            System.out.println("in While: head = " + head.data);
            while(head.next != null) {
                //case: head = head.next => head = head+1 : { data: n+1, null}
                head = head.next;
            }
            //head+1: { new Head(n+2) }
            head.next = new SinglyLinkedListNode(data);
            return head;
        }
    }

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();
        int[] numbers = {100, 200, 300, 400, 500, 600};
        for (int i = 0; i < numbers.length; i++) {
            int llistItem = numbers[i];
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);
            llist.head = llist_head;
        }

        printSinglyLinkedList(llist.head, "\n");
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(" " + node.data);

            node = node.next;

            if (node != null) {
                System.out.print(" " + node.data);
            }
        }
    }
}
