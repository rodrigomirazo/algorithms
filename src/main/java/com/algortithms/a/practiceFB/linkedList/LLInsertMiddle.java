package com.algortithms.a.practiceFB.linkedList;

public class LLInsertMiddle {

    public static void main(String[] args) {
        Node node = new Node(1);
        //insert
        node = insert(node, 2);
        node = insert(node, 3);
        node = insert(node, 5);
        node = inserAfter(node, 4, 3);

        print(node);

    }

    //{ 1, 2, 3, 4-> 5, 5 -> null  }
    static Node inserAfter(Node node, int data, int after) {
        if(node == null)
            return node;

        //node => 3
        if(node.data == after) {
            //node.data = 3
            Node newNode = new Node(data); // 4

            Node temp = node.next;// -> 5
            node.next = newNode; //4 -> null
            newNode.next = temp;

            node.next = inserAfter(node.next, data, after);

        } else {
            node.next = inserAfter(node.next, data, after);
        }

        return node;
    }

    static void print(Node node) {
        if(node == null)
            return;

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
