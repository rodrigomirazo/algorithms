package com.algortithms.a.practiceFB.linkedList;

public class MergeLinkedList {

    static MergeLinkedList merge = new MergeLinkedList();

    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1 = insert(head1, 20);
        head1 = insert(head1, 60);
        head1 = insert(head1, 10);
        head1 = insert(head1, 50);
        head1 = insert(head1, 30);

        Node head2 = new Node(40);
        head2 = insert(head2, 25);
        head2 = insert(head2, 65);
        head2 = insert(head2, 15);
        head2 = insert(head2, 55);
        head2 = insert(head2, 35);


        Node mergeList = mergesort(head1, head2);
        print(mergeList);
    }

    static Node mergesort(Node head1, Node head2) {
        //head1-> 10
        //head2-> 65
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        Node mergeList;

        if(head1.data <= head2.data) {
            mergeList = head1;// mergeList = 10 -> 20 -> 40 -> 60 -> ?
            mergeList.next = mergesort(head1.next, head2);
        } else {
            mergeList = head2;
            mergeList.next = mergesort(head1, head2.next);
        }


        return mergeList;
    }



    static void print(Node node) {
        if(node == null)
            return ;

        System.out.print(node.data + " ");
        print(node.next);
    }

    static Node insert(Node node, int value) {
        if(node == null)
            return new Node(value);

        node.next = insert(node.next, value);

        return node;
    }
}
