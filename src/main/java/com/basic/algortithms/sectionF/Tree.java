package com.basic.algortithms.sectionF;

public class Tree {

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
        if(node == null)
            return;

        if(depth % targetDepth == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swap(node.left, targetDepth, depth+1);
        swap(node.right, targetDepth, depth+1);
    }

    /**
     * Print In-Order Tree nodes
     * @param root
     */
    static void printInorder(Node root) {
        if(root != null) {

            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);


        }
    }

    /**
     * Search node by data value
     * @param root
     * @param data
     * @return
     */
    static Node searchNode(Node root, int data) {

        //If root is empty OR is not found, return current node
        if(root == null || root.data == data)
            return root;

        if(data < root.data)
            return searchNode(root.left, data);

        //else (data > root.data)
        return insertNode(root.right, data);
    }

    /**
     * Insert Node
     * @param root
     * @param data
     * @return Inserted Node
     */
    static Node insertNode(Node root, int data) {
        //if root is null, insert here
        if(root == null) {
            root = new Node(data);
        }

        //if root is lower than the left leaf, insert here
        else if( data < root.data)
            root.left = insertNode(root.left, data);

        //if root is higher than the left leaf, insert here
        else if(data > root.data)
            root.right = insertNode(root.right, data);

        //if root is EQUAL than the left leaf, insert here
        return root;
    }

    /**
     * Insert Node at specific index
     * @param root
     * @param data
     * @return Inserted Node
     */
    static Node insertNodeAtIndex(Node root, int data) {
        //if root is null, insert here
        if(root == null) {
            root = new Node(data);
        }

        //if root is lower than the left leaf, insert here
        if( data < root.data)
            root.left = insertNode(root.left, data);

        //if root is higher than the left leaf, insert here
        else if(data > root.data)
            root.right = insertNode(root.right, data);

        //if root is EQUAL than the left leaf, insert here
        return root;
    }

}
