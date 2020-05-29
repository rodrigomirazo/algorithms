package com.algortithms.tree;

import java.io.IOException;

public class SumNodes {

    static Node root;

    static Node insertNode(Node node, int data) {
        if(node == null)
            node = new Node(data);

        if(data < node.value)
            node.left = insertNode(node.left, data);
        else if(data > node.value)
            node.right = insertNode(node.right, data);

        return node;
    }

    static void printTree(Node node) {
        if(node == null)
            return ;

        System.out.print(" " + node.value);

        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Node root = new Node(1);
        //sum = 5
        root.left = new Node(2);
        root.right = new Node(3);

        //sum = 22
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //sum = 35
        root.right.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.left.right = new Node(10);
        root.right.left.left = new Node(11);

        /** Min And max Depth **/
        int maxDepth = maxDepth(root);
        int minDepth = minDepth(root);

        /** Total Tree Sum **/
        int totalSum = totalSum(root);

        /** Max Depth Sum **/
        int maxDepthSum = depthSum(root, maxDepth, 0);

        /** Min Depth Sum **/
        int minDepthSum = depthSum(root, minDepth, 0);

        System.out.println("\n=============Min And Max=============");
        System.out.println("     Min depth = " + minDepth(root) );
        System.out.println("     Max depth = " + maxDepth(root) );

        System.out.println("\n=============Total SUM=============");
        System.out.print("     Sum Nodes: ");
        totalSum(root);
        System.out.println( "       = " + totalSum);

        System.out.println("\n\n=============SUM: Min And Max=============");
        System.out.print("     Min Sum Nodes: ");
        depthSum(root, maxDepth, 0);
        System.out.println( "       = " + maxDepthSum);

        System.out.print("\n     Min Sum Nodes: ");
        depthSum(root, minDepth, 0);
        System.out.println( "       = " + minDepthSum);
        System.out.println("\n");

    }

    static int minDepth(Node node) {

        if(node == null)
            return 0;

        return Math.min( minDepth(node.left), minDepth(node.right)  ) + 1;
    }

    static int maxDepth(Node node) {

        if(node == null)
            return 0;

        return Math.max( maxDepth(node.left), maxDepth(node.right)  ) + 1;
    }

    //sum an specific level of the Tree
    static int totalSum(Node node) {

        if (node == null)
            return 0;

        System.out.print(" + " + node.value);
        return node.value + totalSum(node.left) + totalSum(node.right);
    }

    //sum an specific level of the Tree
    static int depthSum(Node node, int max, int countLevel) {

        if (node == null)
            return 0;

        if(max == countLevel + 1) {
            System.out.print( " + " + node.value);
            return node.value;
        }
        return + depthSum(node.left, max, countLevel + 1) + depthSum(node.right, max, countLevel + 1);
    }


}
