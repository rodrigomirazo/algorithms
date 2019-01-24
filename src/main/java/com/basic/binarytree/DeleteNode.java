package com.basic.binarytree;

public class DeleteNode {

    private Node node;

    public DeleteNode(Node node) {
        this.node = node;
    }

    private Node deleteRecursive(Node current, int value) {

        if (current == null) {
            return null;
        }

        if (value == current.value) {
            /** CASES **/

            //Case 1: both nodes are empty
            if (current.left == null && current.right == null) {
                return null;
            }

            //Case 2: Node has one child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            //Case 3: Node has multiple childs

        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    /*
    private int findSmallestValue(Node root) {
        if (root.left == null) {
            root.value;
        } else {
            findSmallestValue(root.left);
        }

        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    */
}
