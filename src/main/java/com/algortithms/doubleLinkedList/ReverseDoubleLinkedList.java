package com.algortithms.doubleLinkedList;

public class ReverseDoubleLinkedList {
    static ReverseDoubleLinkedList reverse = new ReverseDoubleLinkedList();
    public static void main(String[] args) {
        //insert 1, 2, 3, 4, 5
        Node head = new Node(1);
        head = reverse.insertNode(head,2);
        head = reverse.insertNode(head,3);
        head = reverse.insertNode(head,4);
        head = reverse.insertNode(head,5);

        while (head.previous != null) head = head.previous;
        head = reverse.reverseList(head);

        while (head.previous != null) head = head.previous;
        while (head.next != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.print(head.data);

    }

    Node reverseList(Node head) {
        if(head == null)
            return head;

        Node temp = null;

        while (head != null) {

            temp = head.previous;
            head.previous = head.next;
            head.next = temp;
            head = head.previous;
        }
        if (temp != null) {
            head = temp.previous;
        }

        return head;
    }

    Node insertNode(Node head, int data) {
        if (head == null)
            return head;

        Node newNode = new Node(data);
        while (head.next != null) {
            head = head.next;// currenthead -> nextHead
        }
        head.next = newNode;
        newNode.previous = head;

        return head;
    }
}
