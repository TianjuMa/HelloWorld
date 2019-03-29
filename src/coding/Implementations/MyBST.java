package coding.Implementations;

import coding.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * One implementation of Binary Search Tree. Basically containing the following function:
 * search()
 * insert()
 * delete()
 * pre order traverse()
 * in order traverse()
 * post order traverse()
 */
public class MyBST {
    private TreeNode root;

    /**
     * constructor to create a root node with input value.
     *
     * @param value root value.
     */
    public MyBST(int value) {
        root = new TreeNode(value);
    }

    /**
     * search the target value in the tree, with recursive way.
     *
     * @param target target value.
     * @return <tt>true</tt> if the target is found.
     */
    public boolean recurciveSearch(int target) {
        return recursiveSearch(root, target);
    }

    /**
     * search the target value in the tree, with iterative way.
     *
     * @param target target value.
     * @return <tt>true</tt> if the target is found.
     */
    public boolean iterativeSearch(int target) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.key == target) {
                return true;
            } else if (currentNode.key < target) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return false;
    }

    /**
     * Insert the target value into the tree, with recursive way.
     *
     * @param target target value.
     * @return the root node after insertion.
     */
    public TreeNode recursiveInsertI(int target) {
        return recursiveInsertI(root, target);
    }

    /**
     * Another way to insert the target value into the tree, with recursive way.
     *
     * @param target target value.
     * @return the root node after insertion.
     */
    public TreeNode recursiveInsertII(int target) {
        return recursiveInsertII(root, target);
    }

    /**
     * Insert the target value into the tree, with iterative way.
     *
     * @param target target value.
     * @return the root node after insertion.
     */
    public TreeNode iterativeInsert(int target) {
        TreeNode currentNode = root;
        TreeNode returnNode = root;
        TreeNode pre = null;
        while (currentNode != null) {
            pre = currentNode;
            if (currentNode.key < target) {
                currentNode = currentNode.right;
            } else if (currentNode.key > target) {
                currentNode = currentNode.left;
            } else {
                return returnNode;
            }
        }
        if (pre.key < target) {
            pre.right = new TreeNode(target);
        } else {
            pre.left = new TreeNode(target);
        }
        return returnNode;
    }

    /**
     * delete the target value from this tree.
     *
     * @param target target value need to be deleted.
     * @return root node after deletion.
     */
    public TreeNode delete(int target) {
        return delete(root, target);
    }

    /**
     * pre order traverse of this tree with iterative way.
     *
     * @return a list of integer, containing the result of traversal.
     */
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrder(result, root);
        return result;
    }

    /**
     * in order traverse of this tree with iterative way.
     *
     * @return a list of integer, containing the result of traversal.
     */
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(result, root);
        return result;
    }

    /**
     * post order traverse of this tree with iterative way.
     *
     * @return a list of integer, containing the result of traversal.
     */
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrder(result, root);
        return result;
    }

    /**
     * helper function of pre order traverse with iterative way.
     *
     * @param result the result list containing the output.
     * @param root   root node of this tree.
     */
    private void preOrder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            result.add(cur.key);
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
            result.add(cur.key);
        }
    }

    /**
     * helper function of in order traverse with iterative way.
     * cur: a indicator that the whole left subtree of element on the top of stack has been traversed.
     * the next step is to print top of stack, and traverse it's right subtree.
     *
     * @param result the result list containing the output.
     * @param root   root node of this tree.
     */
    private void inOrder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode nextNode = root;
        while (!stack.isEmpty() || nextNode != null) {
            if (nextNode != null) {
                stack.offerFirst(nextNode);
                nextNode = nextNode.left;
            } else {
                result.add(stack.peekFirst().key);
                nextNode = stack.peekFirst().right;
                stack.pollFirst();
            }
        }
    }

    /**
     * helper function of post order traverse with iterative way.
     * key point: prev record the previous node already traversed.
     *
     * @param result the result list containing the output.
     * @param root   root node of this tree.
     */
    private void postOrder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekLast();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerLast(cur.left);
                } else if (cur.right != null) {
                    stack.offerLast(cur.right);
                } else {
                    result.add(cur.key);
                    stack.pollLast();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.offerLast(cur.right);
                } else {
                    result.add(cur.key);
                    stack.pollLast();
                }
            } else {
                result.add(cur.key);
                stack.pollLast();
            }
            prev = cur;
        }
    }

    /**
     * helper function of delete method.
     *
     * @param root   root node in this tree.
     * @param target target value.
     * @return the root node after deletion.
     */
    private TreeNode delete(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.key < target) {
            root.right = delete(root.right, target);
        } else if (root.key > target) {
            root.left = delete(root.left, target);
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        TreeNode smallest = deleteSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    /**
     * helper function to find and delete the node with smallest value in the right sub-
     * tree of one particular node in this tree.
     *
     * @param root the base node need, in which the smallest value need to be deleted.
     * @return this node itself.
     */
    private TreeNode deleteSmallest(TreeNode root) {
        TreeNode prev = root;
        TreeNode cur = root.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right;
        return cur;
    }

    /**
     * helper function of recursive search method.
     *
     * @param root   root node of each recursion function call.
     * @param target target value.
     * @return <tt>true</tt> if the target is found.
     */
    private boolean recursiveSearch(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.key == target) {
            return true;
        } else if (root.key < target) {
            return recursiveSearch(root.right, target);
        } else {
            return recursiveSearch(root.left, target);
        }
    }

    /**
     * helper function of recursive insert method.
     *
     * @param root   root node of each recursion function call.
     * @param target target value.
     * @return the root node after insertion.
     */
    private TreeNode recursiveInsertI(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (root.key == target) {
            return root;
        } else if (root.key < target) {
            root.left = recursiveInsertI(root.left, target);
        } else {
            root.right = recursiveInsertI(root.right, target);
        }
        return root;
    }

    /**
     * * helper function of recursive insert method.
     *
     * @param root   root node of each recursion function call.
     * @param target target value.
     * @return the root node after insertion.
     */
    private TreeNode recursiveInsertII(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        helperInsertToTree(root, target);
        return root;
    }

    /**
     * helper function to insert one value into this tree.
     *
     * @param root   root node of each recursin function call.
     * @param target target value.
     */
    private void helperInsertToTree(TreeNode root, int target) {
        if (root.key > target) {
            if (root.left == null) {
                root.left = new TreeNode(target);
            } else {
                helperInsertToTree(root.left, target);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(target);
            } else {
                helperInsertToTree(root.right, target);
            }
        }
    }
}