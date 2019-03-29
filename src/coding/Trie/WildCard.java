package LaiOffer.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * WildCard Problem: find all words matching the expression with wildcard '?'.
 * in the dictionary '?' can match any single character.
 */
public class WildCard {
    /**
     * Version I
     *
     * @param dic the complete String
     * @param p   the String maybe containing '?'
     * @return true if the two String can match with each other.
     */
    public static List<String> findAllMatchWildCard(String[] dic, String p) {
        TrieNode root = TrieNode.buildTrie(dic);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        isMatchDFSHelper(root, p, 0, result, sb);
        return result;
    }

    /**
     * Version II
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     *
     * @param s original String
     * @param p input pattern
     * @return true if the two String can match.
     */
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        boolean[][] canMatch = new boolean[s.length() + 1][p.length() + 1];
        processBounders(canMatch, s, p);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?') {
                    canMatch[i][j] = canMatch[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    canMatch[i][j] = canMatch[i][j - 1] || canMatch[i - 1][j];
                } else {
                    canMatch[i][j] = canMatch[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
                }
            }
        }
        return canMatch[s.length()][p.length()];
    }

    private void processBounders(boolean[][] canMatch, String s, String p) {
        for (int i = 0; i <= s.length(); i++) {
            canMatch[i][0] = i == 0;
        }
        boolean foundNonStar = false;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*' && !foundNonStar) {
                canMatch[0][j] = true;
            } else {
                canMatch[0][j] = false;
                foundNonStar = true;
            }
        }
    }

    private static void isMatchDFSHelper(TrieNode root, String target, int index, List<String> result, StringBuilder sb) {
        if (root.isEnd) {
            result.add(sb.toString());
            return;
        }
        if (target.charAt(index) == '?') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                sb.append(entry.getKey());
                isMatchDFSHelper(entry.getValue(), target, index + 1, result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            TrieNode next = root.children.get(target.charAt(index));
            if (next != null) {
                sb.append(target.charAt(index));
                isMatchDFSHelper(next, target, index + 1, result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}