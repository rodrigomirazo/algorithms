package com.algorithms.binarytree;

public class FindNode {

    private static Node root;

    public static void main(String[] args) {
        root = InitializeTree.intilizeNode();

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
