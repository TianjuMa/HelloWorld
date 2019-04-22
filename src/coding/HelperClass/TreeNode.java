package coding.HelperClass;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode class for any common Tree data structure.
 */
public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    /**
     * constructor for a TreeNode object, with one integer value.
     *
     * @param value target value.
     */
    public TreeNode(int value) {
        key = value;
        left = null;
        right = null;
        parent = null;
    }

    /**
     * override the toString method. This method can return a level order representation of this tree.
     *
     * @return The result String for level order traversal.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        int size;
        while (containsInteger(queue)) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.key != Integer.MIN_VALUE) {
                    sb.append(cur.key).append(" ");
                } else {
                    sb.append("# ");
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                } else {
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                } else {
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                }
            }
        }
        return sb.toString().trim();
    }

    /**
     * reconstruct a tree with a String input. this String is level order
     * representation of this tree, where '#' representing null.
     *
     * @param input the input String.
     * @return root node of this tree.
     */
    public static TreeNode levelOrderReconstruct(String[] input) {
        if (input == null || input.length == 0 || (input.length == 1 && input[0].equals("#"))) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        queue.offer(root);
        int size = 1;
        int index = 1;
        while (!queue.isEmpty()) {
            int curSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (index < input.length && !input[index].equals("#")) {
                    cur.left = new TreeNode(Integer.parseInt(input[index]));
                    cur.left.parent = cur;
                    queue.offer(cur.left);
                    curSize++;
                }
                index++;
                if (index < input.length && !input[index].equals("#")) {
                    cur.right = new TreeNode(Integer.parseInt(input[index]));
                    cur.right.parent = cur;
                    queue.offer(cur.right);
                    curSize++;
                }
                index++;
            }
            size = curSize;
        }
        return root;
    }

    /**
     * helper function to check whether there exists at least one valid integer in a queue.
     *
     * @param queue the input queue.
     * @return true if at least one integer exists.
     */
    private boolean containsInteger(Queue<TreeNode> queue) {
        for (TreeNode t : queue) {
            if (t.key > Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }
}