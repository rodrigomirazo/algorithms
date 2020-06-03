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

        //root.value = 1 ; inser 2
        if(data < root.value )
            root.left = insert(root.left, data);

        if(data > root.value)
            root.right = insert(root.right, data);

        return root;
    }

    Node delete(Node root, int delValue) {

        if(root == null) {
            return root;
        }

        else if(delValue < root.value) {
            root.left = delete(root.left, delValue);
        }

        else if(root.value > delValue) {
            root.right = delete(root.right, delValue);
        } else {
            //node is a leaf
            if(root.left != null && root.right == null) {
                root = null;
            }
            //node has at least one children
            else if(root.left == null)
                root = root.left;

            else if(root.right == null)
                root = root.right;

            //node has 2 or more children
            else {
                Node successor = treeCrud.findNextestNode(root.right);
                root.value = successor.value;
                root.right = delete(root.right, successor.value);
            }
        }

        return root;
    }

    static Node findNextestNode(Node node) {
        if(node.left == null)
            return node;
        else
            return findNextestNode(node.left);
    }
}
