package com.basic.binarytree;

import java.util.HashMap;

// A Java program to introduce Binary Tree
class BinaryTreeSUM {

    public static void main(String[] args) {

        Node root = InitializeTree.intilizeNode();

        int maxHeight = minTreeHeight(root, 0);
        System.out.println("\nSum Nodes Height = " + sumNodesHeight(root, maxHeight));

        System.out.println(treePath.toString());
    }

    static HashMap<String, Integer> treePath = new HashMap<>();

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
