package com.algorithms.binarytree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BinaryTreeHorizontalAvrg {

    static Hashtable<Integer, List<Integer>> map = new Hashtable<>();

    public static void main(String[] args) {

        /** CircularLinkedCRUD **/
        Node root = InitializeTree.intilizeNode();

        int height = height(root);
        System.out.println("height = " + height);
        for (int i = 0; i < height; i++) {
            appendHorizontalValues(root, 0, i);
        }


        iterateELmenets();
    }

    static void iterateELmenets() {

        map.forEach((key, list) -> {

            System.out.println( key + " avg: " + list.stream().mapToInt(Integer::byteValue).average());
        });
    }

    /* Print nodes at a given level */
    static void appendHorizontalValues(Node root, int initial, int targetLevel) {

        if (root == null)
            return;

        if (initial == targetLevel) {
            List<Integer> list = new ArrayList<>();

            if(map.get(targetLevel) != null) {
                list = map.get(targetLevel);
            }
            list.add(root.value);
            map.put(targetLevel, list);
        }

        appendHorizontalValues(root.left, initial + 1, targetLevel);
        appendHorizontalValues(root.right, initial + 1, targetLevel);
    }

    /**
     * MaxDepth
     * @param node
     * @return
     */
    static int height(Node node)
    {
        if (node == null)
            return 0;

        return 1 + Math.max( height(node.left), height(node.right));
    }
}
