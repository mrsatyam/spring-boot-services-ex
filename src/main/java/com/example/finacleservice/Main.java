package com.example.finacleservice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Given a binary tree, determine if it is a valid binary search tree (BST).
//        Definition: A BST is defined as follows: The left subtree of
//        a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.
//        Input: 2
//              / \
//              1 3    Output: true
//
//
//    Input: 5
//          / \
//          1 4
//          / \
//           3 6
//
//          Output: false Explanation: The root node's value is 5 but its right child's value is 4, which violates the BST rules.
        Node left = new Node(1, null, null);
        Node right = new Node(4, new Node(4, new Node(3, null, null), new Node(6, null, null)), null);

        Node node1 = new Node(5, left, right);

        boolean isBinaryTree = isBinaryTree(node1);

        System.out.println(isBinaryTree);

//        Given a list of strings, find the longest common prefix among all the
//        strings in the list. If there is no common prefix,
//        return an empty string. Example: Input: ["flower", "flow", "flight"]
//        Output: "fl" Input: ["dog", "racecar", "car"] Output: "" (no common prefix)
        List<String> values = Arrays.asList("fix", "fixed", "fixer");
        List<String> values2 = Arrays.asList("dog", "racecar", "car");

        String longestPrefix = getLongestCommonPrefix(values);
        System.out.println(longestPrefix);
    }

    private static String getLongestCommonPrefix(List<String> values) {
       var sLengthStr = values.stream().min((s1,s2)-> Integer.compare(s1.length(), s2.length())).orElse("");
       for(int i = 0;i<sLengthStr.length();i++){
           var prefix = sLengthStr.substring(0, i+1);
           var matcher = values.stream().allMatch(s->s.startsWith(prefix));
           if(!matcher){
               sLengthStr = sLengthStr.substring(0, i);
           }
       }
       return sLengthStr;
    }

    static boolean isBinaryTree(Node node) {
        if (node != null) {
            if (node.left().root() < node.root() && node.right().root() > node.root()) {
                return true;
            }
        }
        return false;

    }

    private record Node(int root,
                        Node left,
                        Node right) {

    }
}
