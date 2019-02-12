package com.basic.binarytree;

import java.util.ArrayList;
import java.util.List;

public class VerticalSum {

    // Driver code
    public static void main(String[] args)
    {
        /**
         *       1
         *     /   \
         *   2      3
         *  / \    / \
         * 4   5  6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(4);
        //root.left.right = new Node(5);
        //root.right.left = new Node(6);
        //root.right.right = new Node(7);

        System.out.println("Vertical Sums are");
        verticalSumDLL(root);
    }

    // Doubly Linked List Node
    static class LLNode
    {
        int data;
        LLNode prev, next;
        public LLNode(int d) { data = d; }
    }

    static void verticalSumDLL(Node root) {
        // Create a doubly linked list node to
        // store sum of lines going through root.
        // Vertical sum is initialized as 0.
        LLNode llnode = new LLNode(0);

        // Compute vertical sum of different lines
        verticalSumDLLUtil(root, llnode);

        // llnode refers to sum of vertical line
        // going through root. Move llnode to the
        // leftmost line.
        while (llnode.prev != null)
            llnode = llnode.prev;

        // Prints vertical sum of all lines starting
        // from leftmost vertical line
        while (llnode != null)
        {
            System.out.print(llnode.data +" ");
            llnode = llnode.next;
        }
    }

    // Constructs linked list
    static void verticalSumDLLUtil(Node node, LLNode llnode)
    {
        // Add current node's data to its vertical line
        llnode.data = llnode.data + node.value;
        System.out.print("node.data = " + node.value + " - ");

        // Recursively process left subtree
        if (node.left != null)
        {
            if (llnode.prev == null)
            {
                llnode.prev = new LLNode(0);
                llnode.prev.next = llnode;
            }
            System.out.print("Left:  node = " + node.left.value + " ||R ");
            verticalSumDLLUtil(node.left, llnode.prev);
        }

        // Process right subtree
        if (node.right != null)
        {
            if (llnode.next == null)
            {
                llnode.next = new LLNode(0);
                llnode.next.prev = llnode;
            }
            System.out.print("right: node = " + node.right.value + " ||R ");
            verticalSumDLLUtil(node.right, llnode.next);
        }
    }

    static void printLinkedList(LLNode llNode) {

        List<Integer> dataList = new ArrayList<>();

        System.out.print("Next LinkedList: ");
        while(llNode.next != null) {

            if(!dataList.contains(llNode.data)) {
                dataList.add(llNode.data);
                System.out.print(llNode.data + " ");
            } else {
                break;
            }
        }
        System.out.println();
    }

    static void printLinkedListPrev(LLNode llNode) {

        List<Integer> dataList = new ArrayList<>();

        System.out.print(" Prev LinkedList: ");
        while(llNode.prev != null) {

            if(!dataList.contains(llNode.data)) {
                dataList.add(llNode.data);
                System.out.print(llNode.data + " ");
            } else {
                break;
            }
        }
    }

}
