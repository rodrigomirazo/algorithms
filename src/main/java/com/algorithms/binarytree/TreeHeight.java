
package com.algorithms.binarytree;

public class TreeHeight {

    static int treeHeight() {
        return 0;
    }

    public static Node insertNode(Node node, int data) {
        if(node == null)
            node = new Node(data);

        if( data < node.value)
            node.left = insertNode(node.left, data);

        else if( data > node.value )
            node.right = insertNode(node.right, data);

        return node;
    }

    public static void printTree(Node root) {
        if(root == null)
            return;

        System.out.print(" " + root.value);
        printTree(root.left);
        printTree(root.right);

    }

    static Node root;

    public static void main(String[] args) {
        root = insertNode(root, 1);
        root = insertNode(root, 4);
        root = insertNode(root, 2);
        root = insertNode(root, 5);
        root = insertNode(root, 10);
        root = insertNode(root, 7);
        root = insertNode(root, 3);
        root = insertNode(root, 6);
        root = insertNode(root, 8);
        root = insertNode(root, 9);

        System.out.println("max Height = " + maxHeight(root) );
        System.out.println("min Height = " + minHeight(root) );

        //printTree(root);

    }

    static int maxHeight(Node node) {
        if(node == null)
            return 0;
        else {

            int maxLeft = maxHeight(node.left);
            int maxRight = maxHeight(node.right);

            if (maxLeft > maxRight) {
                return maxLeft + 1;
            } else {
                return maxRight + 1;
            }
        }
    }

    static int minHeight(Node node) {

        if(node == null)
            return 0;

        //if both right and left are null, increase 1
        if(node.left == null && node.right == null)
            return 1;

        //if left is null, recur right subtree
        if(node.left == null)
            return  minHeight(node.right) + 1;

        if(node.right == null)
            return  minHeight(node.left) + 1;

        //compare and return the minimun
        return Math.min(minHeight(node.left),
                minHeight(node.right)) + 1;

    }

}

/*
public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        right = left = null;
    }
}
*/
