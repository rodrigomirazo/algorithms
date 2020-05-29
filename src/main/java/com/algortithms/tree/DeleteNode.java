package com.algortithms.tree;

public class DeleteNode {

    public static void main(String[] args) {
        Node root = InitializeTree.intilizeNode();

        print(root);
        System.out.println();
        Node node1 = deleteNode(root, 80);
        print(node1);
    }

    static void print(Node root) {

        if(root == null)
            return;

        System.out.print(root.value + "-");
        print(root.left);
        print(root.right);
    }

    private static Node deleteNode(Node node, Integer value) {

        if(node == null)
            return null;
        if(value < node.value){
            node.left = deleteNode(node.left, value);
        }else if (value > node.value){
            node.right = deleteNode(node.right, value);
        }else{
            // Leaf node deletion case
            if(node.left == null && node.right == null){
                System.out.println("Leaf node deletion case");
                node = null;
            }
            // Node to be deleted has one child case
            // Node to be deleted has right child
            else if(node.left == null){
                System.out.println("Having One right child deletion case");
                node = node.right;
            }
            // Node to be deleted has left child
            else if(node.right == null){
                System.out.println("Having One left child deletion case");
                node = node.left;
            }
            // Node to be deleted has two children case
            else{
                System.out.println("Two children deletion case");
                Node successor = findSuccessor_recur(node.right);
                // Copy the value
                node.value = successor.value;
                // delete successor node instead
                node.right = deleteNode(node.right, successor.value);
            }
        }
        return node;
    }

    private static Node findSuccessor_recur(Node node){
        if(node.left == null)
            return node;
        else
            return findSuccessor_recur(node.left);

    }

}
