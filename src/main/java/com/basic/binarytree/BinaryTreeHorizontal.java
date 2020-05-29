package com.basic.binarytree;

public class BinaryTreeHorizontal {

    public static void main(String[] args) {

        /** CircularLinkedCRUD **/
        Node root = InitializeTree.intilizeNode();

        System.out.println();
        printGivenLevel(root, 0, 3);
    }

    /* Print nodes at a given level */
    static void printGivenLevel(Node root, int initial, int targetLevel) {

        if (root == null)
            return;
        if (initial == targetLevel)
            System.out.println(root.value);

        printGivenLevel(root.left, initial + 1, targetLevel);
        printGivenLevel(root.right, initial + 1, targetLevel);
    }

}
