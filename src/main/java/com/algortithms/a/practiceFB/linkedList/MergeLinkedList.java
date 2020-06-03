package com.algortithms.a.practiceFB.linkedList;

public class MergeLinkedList {

    static MergeLinkedList merge = new MergeLinkedList();

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(8);
        head1.next.next.next = new Node(12);
        head1.next.next.next.next = new Node(18);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(6);
        head2.next.next.next.next = new Node(22);

        Node head = merge.mergeList(head1, head2);

        System.out.println("Print:");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    Node mergeList(Node head1, Node head2) {
        Node mergeList = null;

        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        if(head1.data <= head2.data) {
            mergeList = head1;
            head1.next = mergeList(head1.next, head2);
        } else {
            mergeList = head2;
            head2.next = mergeList(head1, head2.next);
        }

        return mergeList;
    }

}
