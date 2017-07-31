package LaiOffer.HelperClass;

import java.util.*;

/**
 * TreeNode class for any common Tree data structure.
 */
public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    /**
     * constructor for a TreeNode object, with one integer value.
     *
     * @param value target value.
     */
    public TreeNode(int value) {
        key = value;
        left = null;
        right = null;
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
        if (input == null || input.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(computeValue(input[0]));
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, root);
        for (int i = 1; i < input.length; i++) {
            if (!input[i].equals("#")) {
                map.put(i, new TreeNode(computeValue(input[i])));
            }
        }
        int level = 1;
        int prevLevelStart = 0;
        int preLevelEnd = 0;
        int curLevelStart;
        int curLevelEnd;
        while (Math.pow(2, level + 1) - 1 <= input.length) {
            curLevelStart = (int) (Math.pow(2, level) - 1);
            curLevelEnd = (int) (Math.pow(2, level + 1) - 2);
            int prevIndex = prevLevelStart;
            int curIndex = curLevelStart;
            boolean finishLeft = false;
            while (prevIndex <= preLevelEnd && curIndex <= curLevelEnd) {
                while (!map.containsKey(prevIndex)) {
                    curIndex += 2;
                    prevIndex++;
                }
                if (prevIndex <= preLevelEnd) {
                    if (!finishLeft) {
                        if (map.containsKey(curIndex)) {
                            map.get(prevIndex).left = map.get(curIndex);
                        }
                        finishLeft = true;
                    } else {
                        if (map.containsKey(curIndex)) {
                            map.get(prevIndex).right = map.get(curIndex);
                        }
                        finishLeft = false;
                        prevIndex++;
                    }
                }
                curIndex++;
            }
            level++;
            prevLevelStart = curLevelStart;
            preLevelEnd = curLevelEnd;
        }
        return root;
    }

    /**
     * transfer a String to its corresponding integer value.
     *
     * @param input the input String.
     * @return the corresponding integer value.
     */
    private static int computeValue(String input) {
        int result = 0;
        int sign = 1;
        int startIndex = 0;
        if (input.charAt(0) == '-') {
            sign = -1;
            startIndex = 1;
        }
        for (int i = startIndex; i < input.length(); i++) {
            result = result * 10 + input.charAt(i) - '0';
        }
        return sign * result;
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