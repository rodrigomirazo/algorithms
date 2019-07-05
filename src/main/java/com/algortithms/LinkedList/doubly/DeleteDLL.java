package com.algortithms.LinkedList.doubly;

public class DeleteDLL {

    static Node head;

    public static void main(String[] args) {

        head = append(head, 1);
        head = append(head, 2);
        head = append(head, 3);
        head = append(head, 4);
        head = append(head, 5);
        head = append(head, 6);
        head = append(head, 7);

        System.out.println("print Recursive: node.data = ");
        print(head);
        System.out.println();

        deleteWhile(head,3);
        //head = deleteRecursive(head, 4);

        System.out.println("\n\nprint Recursive");
        print(head);
    }

    static Node deleteRecursive(Node node, int data) {

        if(node == null)
            return node;

        if(node.data == data) {

            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        deleteRecursive(node.next, data);

        return node;
    }

    static void deleteWhile(Node head, int data) {

        Node temp = head;

        while (temp != null) {

            if(temp.data == data) {
                System.out.print("\n" + "data=" + data + "\n");

                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
            }

            temp = temp.next;
        }

    }

    static void printRecursive(Node head) {

        if(head == null)
            return;

        System.out.print(head.data + " ");

        printRecursive(head.next);
    }

    static void print(Node head) {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    static Node append(Node head, int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node newNode = new Node(new_data);

        Node temp = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        newNode.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return head;
        }

        /* 5. Else traverse till the last node */
        while (temp.next != null)
            temp = temp.next;

        /* 6. Change the next of last node */
        temp.next = newNode;

        /* 7. Make last node as previous of new node */
        newNode.prev = temp;

        return head;
    }

    /* Doubly Linked list Node*/
    static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }
    }
}
