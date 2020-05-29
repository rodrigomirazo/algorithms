package com.algorithms.binarytree;

public class InitializeTree {

    public static void main(String[] args) {
        Node root = intilizeNode();

        print(root);
    }

    static void print(Node root) {
        if(root == null) {
            return ;
        }
        System.out.print(root.value + "-");
        print(root.left);
        print(root.right);

    }

    public static Node intilizeNode() {

        Node root = new Node(1);

        root = addRecursive(root, 4);
        root = addRecursive(root, 2);
        root = addRecursive(root, 8);
        root = addRecursive(root, 7);
        root = addRecursive(root, 9);
        root = addRecursive(root, 3);
        root = addRecursive(root, 5);
        root = addRecursive(root, 6);

        return root;
    }

    private static Node addRecursive(Node root, int value) {

        //Insert the node
        if(root == null) {
            return new Node(value);
        }

        //recursion part
        if ( value < root.value ) {
            root.left = addRecursive(root.left, value);
        }
        if ( value > root.value) {
            root.right = addRecursive(root.right, value);
        }
        // root.value is equal to value (input)
        return root;
    }
}
