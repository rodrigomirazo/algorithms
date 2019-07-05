package com.basic.binarytree;

import java.util.HashMap;

// A Java program to introduce Binary Tree
class BinaryTreeSUM {

    public static void main(String[] args) {

        /** CircularLinkedCRUD **/
        Node root = new Node(1);

        //sum = 5
        root.left = new Node(2);
        root.right = new Node(3);

        //sum = 22
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        //inorder(root);

        System.out.println();

        int maxHeight = minTreeHeight(root, 0);
        System.out.println("\nSum Nodes Height = " + sumNodesHeight(root, maxHeight));

        recordBranches(root);
        System.out.println(treePath.toString());
    }

    static HashMap<String, Integer> treePath = new HashMap<>();

    static void recordBranches(Node node) {
        if(node == null) {
            treePath.put("pick", null);
            return;
        }

        if(node.left != null) {
            treePath.put("left", node.left.value);
            System.out.println(node.left.value + " " + treePath.toString());
        }
        recordBranches(node.left);

        if(node.right != null) {
            treePath.put("right", node.right.value);
            System.out.println( node.right.value + " " + treePath.toString());
        }
        recordBranches(node.right);
    }

    static int sumNodesHeight(Node node, int level) {

        if(node == null)
            return 0;

        if(level == 1)
            return node.value;

        return
            sumNodesHeight(node.left,  level - 1) +
            sumNodesHeight(node.right, level - 1);
    }

    /**
     * Calculate min Height of the Tree
     *
     * @param node
     * @param height
     * @return
     */
    static int minTreeHeight(Node node, int height) {

        if(node == null)
            return 0;

        return Math.min(
                minTreeHeight(node.left, height ),
                minTreeHeight(node.right, height )
        ) + 1;
    }

}
