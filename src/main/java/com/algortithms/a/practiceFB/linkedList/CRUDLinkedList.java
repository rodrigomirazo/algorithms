package com.algortithms.a.practiceFB.linkedList;

import jdk.nashorn.api.scripting.ScriptUtils;

public class CRUDLinkedList {

    static CRUDLinkedList crud = new CRUDLinkedList();

    public static void main(String[] args) {
        Node node = new Node(1);
        //insert
        node = crud.insert(node, 2);
        node = crud.insert(node, 3);
        node = crud.insert(node, 4);
        node = crud.insert(node, 5);

        //print
        System.out.print("print List\n");
        crud.print(node);

        //delete at the middle
        System.out.println("\nprint List");
        //node = crud.delete(node, 2);
        node = crud.deleteNode(node, 2);
        crud.print(node);
    }

    Node delete(Node node, int value) {
        if(node.next == null) {
            return null;
        }

        if(node.data == value) {
            node.data = node.next.data;
            node.next = delete(node.next, node.next.data);
        } else {
            node.next = delete(node.next, value);
        }

        return node;
    }

    Node deleteNode(Node node, int value) {
        if(node == null) {
            return null;
        }

        if(node.data == value) {
            Node temp = node.next;
            node = new Node(temp.data);
            node.next = temp;
            node.next = deleteNode(node.next.next, value);
        } else {
            node.next = deleteNode(node.next, value);
        }

        return node;
    }

    Node insert(Node node, int value) {
        if(node == null)
            return new Node(value);

        node.next = insert(node.next, value);

        return node;
    }

    void print(Node node) {
        if(node == null)
            return;

        System.out.print(node.data + " ");
        print(node.next);

    }
}
