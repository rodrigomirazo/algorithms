package com.algortithms.doubleLinkedList;

public class InsertDoubleLinkedList {
    static InsertDoubleLinkedList crud = new InsertDoubleLinkedList();

    public static void main(String[] args) {
        Node head = new Node(1);
        head = crud.insertAfter(head, 2);
        head = crud.insertAfter(head, 3);
        head = crud.insertBefore(head, 0);
        head = crud.insertAfter(head, 5);
        head = crud.insertAfterNode(head, 3, 4);

        System.out.println("Println:");
        while (head.next != null) head = head.next;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.previous;
        }

    }

    Node insertAfterNode(Node head, int data, int newData) {
        Node after = new Node(newData);
        if(head == null)
            return after;

        //while (head.previous != null) head = head.previous;
        while (head.next != null) {
            if(head.data == data) {
                after.next = head.next;
                after.previous = head;
                head.next.previous = after;
                head.next = after;
            }
            head = head.next;
        }

        return head;
    }

    Node insertAfter(Node head, int data) {
        Node afterNode = new Node(data);
        if(head == null) {
            return afterNode;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = afterNode;
        afterNode.previous = head;

        return head;
    }

    Node insertBefore(Node head, int data) {
        Node beforeNode = new Node(data);

        if(head == null) {
            return beforeNode;
        }
        while (head.previous != null)
            head = head.previous;

        head.previous = beforeNode;
        beforeNode.next = head;

        return head;
    }

}
