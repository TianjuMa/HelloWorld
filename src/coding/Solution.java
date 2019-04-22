package coding;

import coding.HelperClass.TreeNode;

import java.util.*;

/**
 * Solution class for coding practice.
 */

public class Solution {
    public void inorder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = firstNode(root);
        while(cur != null) {
            System.out.println(cur.key);
            cur = nextNode(cur);
        }
    }

    private TreeNode firstNode(TreeNode node) {
        if (node == null) return node;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode nextNode(TreeNode cur) {
        if (cur.right != null) {
            return firstNode(cur.right);
        }
        while (cur.parent != null && cur == cur.parent.right) {
            cur = cur.parent;
        }
        return cur.parent;
    }
}