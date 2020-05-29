package com.algortithms.LinkedList.simple;

public class Node {

    int data;
    Node next;

    // Constructor
    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "SimpleNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
