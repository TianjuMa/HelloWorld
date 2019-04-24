package coding.MyIterators;

import coding.HelperClass.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implementation of one iterator of Binary Search Tree.
 */
public class BSTIterator {
    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        diveLeft(stack, root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public Integer next() {
        TreeNode result;
        if (hasNext()) {
            result = stack.pollFirst();
            diveLeft(stack, result.right);
            return result.val;
        }
        return null;
    }

    private void diveLeft(Deque<TreeNode> stack, TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
    }
}