package com.basic.binarytree;

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

    public static void main(String[] args) {
        //root = insertNode(root, 1);
        //root = insertNode(root, 2);
        //root = insertNode(root, 3);
        //root = insertNode(root, 4);
        //root = insertNode(root, 5);
        //root = insertNode(root, 6);
        //root = insertNode(root, 7);

        Node root = new Node(1);
        //sum = 5
        root.left = new Node(2);
        root.right = new Node(3);

        //sum = 22
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ////sum = 35
        //root.right.right.right = new Node(8);
        //root.right.right.left = new Node(9);
        //root.right.left.right = new Node(9);
        //root.right.left.left = new Node(9);
        ////sum = 100
        //root.right.right.left.left = new Node(9);
        //root.right.right.left.right = new Node(10);
        //root.right.right.right.left = new Node(11);
        //root.right.right.right.right = new Node(12);
        //root.right.left.left.left = new Node(15);
        //root.right.left.left.right = new Node(16);
        //root.right.left.right.left = new Node(13);
        //root.right.left.right.right = new Node(14);

        printTree(root);
        System.out.println();
        //ifrst maximun dept
        int maxDepth = maxDepth(root);
        System.out.println("Max depth = " + maxDepth(root) );
        //System.out.println("Min depth = " + minDepth(root) );
        System.out.println("Sum depth = " +  depthSum(root, maxDepth) );

    }

    //sum an specific level of the Tree
    static int depthSum(Node node, int max) {

        if (node == null)
            return 0;

        System.out.println("node value = " + node.value + " || max = " + max);
        if(max == 1)
            return node.value;

        return depthSum(node.left, max - 1) + depthSum(node.right, max - 1);
    }

    static int maxDepth(Node node) {

        if(node == null)
            return 0;

        return Math.max( maxDepth(node.left), maxDepth(node.right)  ) + 1;
    }

    static int minDepth(Node node) {

        if(node == null)
            return 0;

        return Math.min( minDepth(node.left), minDepth(node.right)  ) + 1;
    }


}
