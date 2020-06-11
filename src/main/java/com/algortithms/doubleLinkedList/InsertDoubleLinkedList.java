package com.algortithms.doubleLinkedList;

public class InsertDoubleLinkedList {
    static InsertDoubleLinkedList crud = new InsertDoubleLinkedList();

    public static void main(String[] args) {
        Node head = new Node(1);
        head = crud.insertAfter(head, 2);
        head = crud.insertAfter(head, 3);
        //head = crud.insertBefore(head, 0);
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
        if(head == null)
            return head;
        Node newNode = new Node(newData);
        while (head.next != null) {
            if(head.data == data) {
                newNode.next = head.next;
                newNode.previous = head;

                head.next.previous = newNode;
                head.next = newNode;
            }
            head = head.next;
        }

        return head;
    }

    Node insertAfter(Node head, int newData) {
        if(head == null)
            return head;

        while (head.next != null) {
            head = head.next;
        }
        Node newnode = new Node(newData);
        head.next = newnode;
        newnode.previous = head;

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
