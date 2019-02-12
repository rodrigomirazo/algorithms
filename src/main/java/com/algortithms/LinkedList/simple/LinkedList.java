package com.algortithms.LinkedList.simple;

public class LinkedList {

    static LinkedListService linkedListService = new LinkedListService();
    static LinkedListService linkedListService2 = new LinkedListService();

    public static void main(String[] args) {

        linkedListService = linkedListService.fillLinkedList();
        linkedListService2 = linkedListService2.fillLinkedList_2();

    }




}
