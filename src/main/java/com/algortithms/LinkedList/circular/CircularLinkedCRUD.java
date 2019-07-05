package com.algortithms.LinkedList.circular;

public class CircularLinkedCRUD {
    static CircularNode Head;
    static CircularNode tail;

    public static void main(String[] args) {
        Head = new CircularNode(1);

        /* Initialize lists as empty */
        CircularNode head = null;

        /* Created linked list will be 2.5.7.8.10 */
        head = push(head, 2);
        head = push(head, 5);
        head = push(head, 7);
        head = push(head, 8);
        head = push(head, 10);

        System.out.printf("List Before Deletion: ");
        printList(head);

        head = deleteNode(head, 7);

        System.out.printf("List After Deletion: ");
        printList(head);
    }

    static void printList(CircularNode head) {
        CircularNode temp = head;
        if (head != null) {
            do {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            } while (temp != head);
        }
    }

    /* Function to delete a given node from the list */
    static CircularNode deleteNode(CircularNode head, int key) {
        if (head == null)
            return null;

        // Find the required node
        CircularNode temp = head, prev = new CircularNode();
        while (temp.data != key) {
            if (temp.next == head) {
                System.out.printf("\nGiven node is not found"
                        + " in the list!!!");
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        // Check if node is only node
        if (temp.next == head) {
            head = null;
            return head;
        }

        // If more than one node, check if
        // it is first node
        if (temp == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = temp.next;
            prev.next = head;
        }

        // check if node is last node
        else if (temp.next == head) {
            prev.next = head;
        }
        else {
            prev.next = temp.next;
        }
        return head;
    }

    static CircularNode push(CircularNode head_ref, int data)
    {
        // Create a new node and make head as next
        // of it.
        CircularNode ptr1 = new CircularNode();
        ptr1.data = data;
        ptr1.next = head_ref;

        /* If linked list is not null then set the
    next of last node */
        if (head_ref != null) {
            // Find the node before head and update
            // next of it.
            CircularNode temp = head_ref;
            while (temp.next != head_ref)
                temp = temp.next;
            temp.next = ptr1;
        }
        else
            ptr1.next = ptr1; /*For the first node */

        head_ref = ptr1;
        return head_ref;
    }

}
