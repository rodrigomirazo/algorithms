package com.algortithms.tree;

public class NumberOfNodes {


    public static void main(String[] args) {

        Node root = InitializeTree.intilizeNode();

        Node nodeRef = getNodeRecursive(root, 1);

        int nodesIntree = countNodes(nodeRef, 0);

        System.out.println("nodesIntree: " + nodesIntree);
    }

    static int countNodes(Node node, int count) {
        if(node == null) {
            return 0;
        }
        //EACH of the recursions most increase by 1 the count parameter
        return countNodes(node.left, count) + countNodes(node.right, count) + 1;
    }

    private static Node getNodeRecursive(Node root, int value) {

        //If root node is empty
        if (root == null) {
            return null;
        }

        //If root nose is equal
        if (value == root.value) {
            return root;
        }

        if (value < root.value) {
            return getNodeRecursive(root.left, value);
        } else {
            return getNodeRecursive(root.right, value);
        }

    }
}
