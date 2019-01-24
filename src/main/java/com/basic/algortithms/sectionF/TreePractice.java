package com.basic.algortithms.sectionF;

public class TreePractice {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    static Node root;

    public static void main(String[] args) {

        //inser a coouple of elements
        root = new Node(3);

        insertNode(root, 2);
        insertNode(root, 1);

        //Print in order
        printInorder(root);

        //swap
        swap(root, 1, 2);

        System.out.println("\nAfter swap:");
        //Print in order, after swap
        printInorder(root);
    }

    static void swap(Node node, int targetDepth, int depth) {

    }

    /**
     * Print In-Order Tree nodes
     * @param root
     */
    static void printInorder(Node root) {

    }

    /**
     * Search node by data value
     * @param root
     * @param data
     * @return
     */
    static Node searchNode(Node root, int data) {

        return null;
    }

    /**
     * Insert Node
     * @param root
     * @param data
     * @return Inserted Node
     */
    static Node insertNode(Node root, int data) {

        return null;
    }


}
