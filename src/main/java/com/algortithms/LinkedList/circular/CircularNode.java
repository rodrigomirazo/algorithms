package com.algortithms.LinkedList.circular;

public class CircularNode {
    int data;
    CircularNode next;

    public CircularNode() {
        this.next = null;
    }

    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}
