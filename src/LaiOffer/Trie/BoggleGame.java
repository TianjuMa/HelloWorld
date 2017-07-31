package LaiOffer.Trie;

import java.util.*;

/**
 * Boggle Game: Given a matrix of characters, you can move from one cell to the neighbor
 * cell (up, down, left, right), on the same path, each cell can be used only once. Find
 * all possible words that can be formed by a sequence of adjacent character.
 */
public class BoggleGame {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<String> boggleGameNaive(char[][] matrix, String[] dic) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, dic);
        for (String s : set) {
            if (existWord(matrix, s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static List<String> BoggleGameOptimized(char[][] matrix, String[] dic) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || dic == null || dic.length == 0) {
            throw new IllegalArgumentException("illegal argument.");
        }
        TrieNode root = TrieNode.buildTrie(dic);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                BoggleGameOptimizedDFSHelper(matrix, root, result, sb, i, j, visited);
            }
        }
        return result;
    }

    private static boolean existWord(char[][] matrix, String word) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (boggleGameNaiveDFSHelper(matrix, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean boggleGameNaiveDFSHelper(char[][] matrix, int row, int col,
                                                    int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col] || matrix[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        for (int[] dir : DIRS) {
            if (boggleGameNaiveDFSHelper(matrix, row + dir[0], col + dir[1], index + 1, word, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    private static void BoggleGameOptimizedDFSHelper(char[][] matrix, TrieNode root, List<String> result,
                                                     StringBuilder sb, int row, int col, boolean[][] visited) {
        if (root.isEnd) {
            result.add(sb.toString());
            root.isEnd = false;
            return;
        }
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix.length || visited[row][col]) {
            return;
        }
        TrieNode next = root.children.get(matrix[row][col]);
        if (next != null) {
            sb.append(matrix[row][col]);
            visited[row][col] = true;
            for (int[] dir : DIRS) {
                BoggleGameOptimizedDFSHelper(matrix, next, result, sb, row + dir[0], col + dir[1], visited);
            }
            visited[row][col] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}