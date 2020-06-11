package com.algortithms.a.practiceFB.tree;

public class BreathFirstSearch {

    static BreathFirstSearch BFS = new BreathFirstSearch();

    public static void main(String[] args) {

        Node root = new Node(5);
        root = BFS.insert(root, 1);
        root = BFS.insert(root, 3);
        root = BFS.insert(root, 4);
        root = BFS.insert(root, 2);

        BFS.breadFirstSEarch(root, 3);

        //System.out.println("print min = " + BFS.minHeight(root));
    }

    void breadFirstSEarch(Node root, int level) {
        if(root == null)
            return;

        if(level == 0)
            System.out.print(root.value + " ");

        breadFirstSEarch(root.left, level - 1);
        breadFirstSEarch(root.right, level - 1);
    }

    static void print(Node root) {

        if(root == null)
            return;

        System.out.print(root.value + "-");
        print(root.left);
        print(root.right);
    }

    Node insert(Node root, int value) {
        if(root == null)
            return new Node(value);

        if(value < root.value)
            root.left = insert(root.left, value);
        if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

}
