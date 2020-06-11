package com.algortithms.a.practiceFB.tree;

public class TreeCRUD {
    static TreeCRUD treeCrud = new TreeCRUD();
    public static void main(String[] args) {


        Node root = new Node(1);
        //insert 1
        //insert 2
        //insert 3
        //delete 2
        root = treeCrud.insert(root, 3);
        root = treeCrud.insert(root, 5);
        root = treeCrud.insert(root, 4);
        root = treeCrud.insert(root, 8);
        root = treeCrud.insert(root, 2);
        root = treeCrud.delete(root, 5);

        treeCrud.printRecursive(root);
    }

    void printRecursive(Node root) {
        if(root == null)
            return;

        System.out.print(root.value + " ");

        printRecursive(root.left);
        printRecursive(root.right);
    }

    Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if (data < root.value) {
            root.left = insert(root.left, data);
        }
        if (data > root.value) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    Node delete(Node root, int delValue) {
        if(root == null)
            return root;
        //root.value = 5; delVallue = 4
        if(root.value > delValue)
            root.left = delete(root.left, delValue);
        else if(root.value < delValue)
            root.right = delete(root.right, delValue);

        else {
            if(root.left == null && root.right == null) {
                root = null;
            }
            else if(root.left == null) {
                root = root.right;
            }
            else if(root.right == null) {
                root = root.left;
            }
            else {
                Node nextest = findNextestNode(root.right);
                root.value = nextest.value;
                root.right = delete(root.right, nextest.value);
            }

        }

        return root;
    }

    static Node findNextestNode(Node node) {
        if(node.left == null)
            return node;

        node.left = findNextestNode(node.left);
        return node;
    }
}
