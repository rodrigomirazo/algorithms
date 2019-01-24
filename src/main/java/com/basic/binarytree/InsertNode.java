package com.basic.binarytree;

public class InsertNode {

    private Node root;

    public InsertNode(Node root) {
        this.root = root;
    }

    private Node addRecursive(Node current, int insertValue) {
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

        // value already exists
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

}
