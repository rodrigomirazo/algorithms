package com.basic.binarytree;

public class TreeSwap {

    static class Node {
        int data;
        Node left;
        Node right;
        int depth;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node root;

    public static void main(String[] args) {

        //inser a coouple of elements
        for(int i = 1; i <= 3; i++) {

        }

        root = new Node(3);
        insertNodeAtLeft_AfterValue(root, 3, 2);
        insertNodeAtRight_AfterValue(root, 2, 1);

        //Print in order
        printInorder(root);

        //swap
        swap2(root);

        System.out.println("\nAfter swap:");
        //Print in order, after swap
        printInorder(root);
    }

    static void swap(Node node, int targetDepth, int depth) {
        if(node != null) {
            //return;

            if (depth % targetDepth == 0) {
                Node temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            swap(node.left, targetDepth, depth + 1);
            swap(node.right, targetDepth, depth + 1);
        }
    }

    static void swap2(Node node) {
        if(node == null)
            return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        swap2(node.left);
        swap2(node.right);
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
     * Search and insert node at the left of the node
     * @param root
     * @param newData
     * @return
     */
    static void insertNodeAtLeft_AfterValue(Node root, int searchData, int newData) {

        //If root is empty OR is not found, return current node
        if(root != null) {
            if (root.data == searchData)
                root.left = new Node(newData);

            insertNodeAtLeft_AfterValue(root.left, searchData, newData);
            insertNodeAtLeft_AfterValue(root.right, searchData, newData);
        }
    }

    /**
     * Search and insert node at the right of the node
     * @param root
     * @param newData
     * @return
     */
    static void insertNodeAtRight_AfterValue(Node root, int searchData, int newData) {

        //If root is empty OR is not found, return current node
        if(root != null) {
            if (root.data == searchData)
                root.right = new Node(newData);

            insertNodeAtRight_AfterValue(root.left, searchData, newData);
            insertNodeAtRight_AfterValue(root.right, searchData, newData);
        }
    }

    /**
     * Insert Node
     * @param root
     * @param data
     * @return Inserted Node
     */
    static Node insertOrderNode(Node root, int data) {
        //if root is null, insert here
        if(root == null) {
            root = new Node(data);
        }

        //if root is lower than the left leaf, insert here
        else if( data < root.data)
            root.left = insertOrderNode(root.left, data);

        //if root is higher than the left leaf, insert here
        else if(data > root.data)
            root.right = insertOrderNode(root.right, data);

        //if root is EQUAL than the left leaf, insert here
        return root;
    }

    /**
     * Insert Node at the left
     * @param root
     * @param data
     * @return Inserted Node
     */
    static Node insertNodeAtLeft(Node root, int data) {
        //if root is null, insert here
        if(root == null) {
            root = new Node(data);
        }
        root.left = insertNodeAtLeft(root.left, data);

        //if root is EQUAL than the left leaf, insert here
        return root;
    }

    /**
     * Insert Node at the Right
     * @param root
     * @param data
     * @return Inserted Node
     */
    static Node insertNodeAtRight(Node root, int data) {
        //if root is null, insert here
        if(root == null) {
            root = new Node(data);
        }
        root.left = insertNodeAtLeft(root.left, data);

        //if root is EQUAL than the left leaf, insert here
        return root;
    }

}
