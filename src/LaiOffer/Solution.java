package LaiOffer;

import LaiOffer.HelperClass.ListNode;
import LaiOffer.HelperClass.Point;
import LaiOffer.HelperClass.TreeNode;

import java.util.*;

/**
 * Solution class for coding practice.
 */
public class Solution {
    private final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(result, sb, root, board, i, j);
            }
        }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            insertToTrie(root, s);
        }
        return root;
    }

    private void insertToTrie(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
            if (i == word.length() - 1) {
                root.isEnd = true;
            }
        }
    }

    private void helper(List<String> result, StringBuilder sb, TrieNode root, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char c = board[row][col];
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        sb.append(c);
        if (root.isEnd) {
            result.add(sb.toString());
            root.isEnd = false;
        }
        board[row][col] = '#';
        for (int[] dir : DIRS) {
            helper(result, sb, root, board, row + dir[0], col + dir[1]);
        }
        sb.deleteCharAt(sb.length() - 1);
        board[row][col] = c;
    }
}
