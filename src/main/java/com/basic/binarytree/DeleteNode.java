package com.basic.binarytree;

public class DeleteNode {

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.left = new Node(80);
        /**
         *         50
         *      /     \
         *     30      70
         *    /  \    /  \
         *  20   40  60   80
         */

        print(root);
        System.out.println();
        deleteRecursive(root, 50);
        print(root);
    }

    static void print(Node root) {

        if(root == null)
            return;

        print(root.left);
        System.out.print(root.value + " ");
        print(root.right);
    }

    static private Node deleteRecursive(Node node, int value) {

        if(node == null)
            return node;
        //Recur Next Values
        else if( value < node.value )
            node.left = deleteRecursive(node.left, value);
        else if( value > node.value)
            node.right = deleteRecursive(node.right, value);
        //if(node.value == value)
        else {

            //Case 1: node with only one child or no child
            if (node.left == null)
                return node.right;

            else if (node.right == null)
                return node.left;

            //Case 2: node with two children: Get the inorder successor
            node.value = minValue(node.right);

            // Delete the inorder successor
            node.right = deleteRecursive(node.right, node.value);
        }

        return node;
    }

    // smallest in the subtree
    static int minValue(Node root) {
        int minv = root.value;
        //As is a binary tree, it should be the left leaf
        while (root.left != null) {

            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

}
