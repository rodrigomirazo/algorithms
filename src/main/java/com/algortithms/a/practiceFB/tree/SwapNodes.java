package com.algortithms.a.practiceFB.tree;

public class SwapNodes {

    public static void main(String[] args) {
        Node root = new Node(1);
        root = insert(root, 10);
        root = insert(root, 4);
        root = insert(root, 9);
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 5);

        System.out.println("Before:");
        print(root);

        swap(root);

        System.out.println("\nAfter:");
        print(root);
    }

    static void swap(Node root) {
        if(root == null)
            return ;

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        swap(root.right);
        swap(root.left);
    }

    static void print(Node root) {
        if(root == null)
            return;

        System.out.print(root.value + " ");

        print(root.left);
        print(root.right);
    }

    static Node insert(Node root, int data) {
        if(root == null)
            return new Node(data);

        if(data < root.value)
            root.left = insert(root.left, data);
        if (data > root.value)
            root.right = insert(root.right, data);

        return root;
    }
}
