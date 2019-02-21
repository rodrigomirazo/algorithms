package com.basic.binarytree;

// A Java program to introduce Binary Tree
class BinaryTreeCRUD {

    // Root of Binary Tree
    static Node root;
    static Node root2;

    public static void main(String[] args) {

        /** CRUD **/
        root = insert(root, 5);
        root = insert(root, 1);
        root = insert(root, 3);

        System.out.println("root 1");
        inorder(root);
        //root =
        delete(root, 5);

        System.out.println("");
        inorder(root);
    }

    static void inorder(Node node) {

        if(node == null)
            return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    /**
     * Insert Node
     *
     * @param node
     * @param value
     * @return
     */
    static Node insert(Node node, int value) {

        if(node == null)
            node = new Node(value);

        else if( value < node.value)
            node.left = insert(node.left, value);

        else if( value > node.value)
            node.right = insert(node.right, value);

        return node;
    }

    /**
     * Delete Node
     *
     * @param node
     * @param value
     * @return
     */
    static Node delete(Node node, int value) {

        if(node == null)
            return node;
        else if(value < node.value)
            node.left = delete(node.left, value);

        else if(value > node.value)
            node.right = delete(node.right, value);

        //Means we've found the node to be deleted
        else {

            //Case 1: node to be deleted is a leaf
            if(node.left == null)
                return node.left;

            else if(node.right == null)
                return node.right;

            /** Case 2: node  is a

                50                           60º
              /   \         delete(50)     /   \
             40   70*      --------->     40   70
                 /  \    left < right           \
                60º 80                          80
            */

            node.value = minBranchValue(node.right);
            node.right = delete(node.right, value);
        }

        return node;
    }

    static int minBranchValue(Node node) {

        int minVal = node.value;
        while (node.left != null) {
            node = node.left;
            minVal = node.value;
        }

        return minVal;
    }

}
