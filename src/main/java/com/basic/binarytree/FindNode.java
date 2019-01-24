package com.basic.binarytree;

public class FindNode {

    private Node root;

    public FindNode(Node root) {
        this.root = root;
    }

    private boolean containsNodeRecursive(Node current, int value) {

        //If current node is empty
        if (current == null) {
            return false;
        }

        //If current nose is equal
        if (value == current.value) {
            return true;
        }

        //if
        if (value < current.value) {
            return containsNodeRecursive(current.left, value);
        } else {
            return containsNodeRecursive(current.right, value);
        }

    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

}
