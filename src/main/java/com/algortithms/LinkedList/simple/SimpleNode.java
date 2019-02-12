package com.algortithms.LinkedList.simple;

public class SimpleNode {

    int data;
    SimpleNode next;

    // Constructor
    SimpleNode(int d) {
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
