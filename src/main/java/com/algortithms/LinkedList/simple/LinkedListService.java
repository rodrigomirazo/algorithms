package com.algortithms.LinkedList.simple;

public class LinkedListService {

    public static LinkedListInsert insertNode(LinkedListInsert linkedList, int data) {

        //Declare Head List
        LinkedListInsert.Node newHead = new LinkedListInsert.Node(data);

        if( linkedList.head == null ) {
            linkedList.head = newHead;

        } else {

            //Iterate List unitl the last Node
            LinkedListInsert.Node iterate = linkedList.head;
            while (iterate.next != null) {
                iterate = iterate.next;
            }

            iterate.next = newHead;
        }

        return linkedList;
    }

    public SimpleNode insert(SimpleNode simpleNode, int data) {

        if(simpleNode == null) {
            System.out.println("null");
            simpleNode = new SimpleNode(data);
        } else {
            System.out.println("Not null");
            while (simpleNode.next != null) {

                simpleNode = simpleNode.next;
                System.out.println(simpleNode.toString());
            }
            simpleNode.next = new SimpleNode(data);
        }

        return simpleNode;
    }

    public void printLinkedList(SimpleNode simpleNode) {
        System.out.print("\nLinkedLsit = [");

        SimpleNode simpleNode1 = simpleNode;

        while (simpleNode1 != null) {
            System.out.print(simpleNode1.data + ", ");
            simpleNode1 = simpleNode1.next;
        }
        System.out.print("]\n");
    }

    public SimpleNode fillLinkedList_1() {
        SimpleNode simpleNode = new SimpleNode(0);

        simpleNode = insert(simpleNode, 10);
        simpleNode = insert(simpleNode, 20);
        simpleNode = insert(simpleNode, 30);
        simpleNode = insert(simpleNode, 40);
        simpleNode = insert(simpleNode, 60);

        printLinkedList(simpleNode);

        return simpleNode;
    }

    public SimpleNode fillLinkedList_2() {
        SimpleNode simpleNode = new SimpleNode(5);

        simpleNode = insert(simpleNode, 15);
        simpleNode = insert(simpleNode, 25);
        simpleNode = insert(simpleNode, 35);
        simpleNode = insert(simpleNode, 45);
        simpleNode = insert(simpleNode, 65);

        printLinkedList(simpleNode);

        return simpleNode;
    }

}
