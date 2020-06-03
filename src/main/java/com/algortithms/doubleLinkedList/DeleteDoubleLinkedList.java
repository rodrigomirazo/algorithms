package com.algortithms.doubleLinkedList;

public class DeleteDoubleLinkedList {
    static DeleteDoubleLinkedList del = new DeleteDoubleLinkedList();

    public static void main(String[] args) {
        Node head = new Node(1);
        head = del.pushNode(head, 2);
        head = del.pushNode(head, 3);
        head = del.pushNode(head, 4);
        head = del.pushNode(head, 5);
        head = del.pushNode(head, 6);
        head = del.pushNode(head, 7);
        head = del.delteAt(head, 4);

        head = del.delteAtEnd(head);
        head = del.delteAtStart(head);

        System.out.println("Print:");
        while (head.previous != null) head = head.previous;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    Node delteAt(Node head, int delData) {
        if(head == null || head.next == null)
            return head;

        while (head.previous != null) head = head.previous;
        while (head.next != null) {
            if(head.data == delData) {
                head.next.previous = head.previous;
                head.previous.next = head.next;
            }
            head = head.next;
        }
        return head;
    }

    Node delteAtStart(Node head) {
        if(head == null || head.previous == null)
            return head;
        while (head.previous != null) {
            head = head.previous;
        }
        head = head.next;
        head.previous = null;

        return head;
    }

    Node delteAtEnd(Node head) {
        if(head == null || head.next == null)
            return head;
        while (head.next != null) {
            head = head.next;
        }
        head.previous.next = null;

        return head;
    }

    Node pushNode(Node head, int data) {
        Node newNode = new Node(data);

        if(head == null)
            return head;

        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
        newNode.previous = head;

        return head;
    }
}
