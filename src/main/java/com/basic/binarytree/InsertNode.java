package com.basic.binarytree;

public class InsertNode {

    private Node root;

    static private Node addRecursive(Node current, int insertValue) {
        // If the  current node IS EMPTY,
        // a new NODE will be CREATED
        if (current == null) {
            return new Node(insertValue);
        }

        //If the VALUE to be Inserted is MINOR than the current Value
        // it will be inserted at the LEFT
        if (insertValue < current.value) {
            current.left = addRecursive(current.left, insertValue);

        //If the VALUE to be Inserted is MAYOR than the current Value
        // it will be inserted at the RIGHT
        } else if (insertValue > current.value) {
            current.right = addRecursive(current.right, insertValue);
        }

        return current;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root = addRecursive(root, 2);
        root = addRecursive(root, 5);
        root = addRecursive(root, 3);
    }

}
