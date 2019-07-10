package coding.Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Trie Node implementation of Trie tree data structure.
 */
public class TrieNode {
    /**
     * map contains all the paths from this node. Key is character, representing one char
     * at this position, and Value is the corresponding Trie Node under this node.
     */
    private Map<Character, TrieNode> children;

    /**
     * this boolean value represents whether this node locates in the end position of one word.
     */
    private boolean isEnd;

    /**
     * this integer value represents how many ending nodes under this node, including this node itself.
     */
    private int count;

    /**
     * constructor for this class.
     */
    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
        count = 0;
    }

    /**
     * build a Trie tree from a given String array, and return the root node of this tree.
     *
     * @param dic the input String array.
     * @return root node of this tree.
     */
    public static TrieNode buildTrie(String[] dic) {
        Arrays.sort(dic);
        TrieNode root = new TrieNode();
        for (String word : dic) {
            insert(root, word);
        }
        return root;
    }

    /**
     * search a target word in a given Trie tree.
     *
     * @param root   root node of this Trie tree.
     * @param target target word.
     * @return true if this word is found.
     */
    public static boolean search(TrieNode root, String target) {
        if (root == null && (target == null || target.length() == 0)) {
            return true;
        }
        if (root == null) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < target.length(); i++) {
            TrieNode next = cur.children.get(target.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isEnd;
    }

    /**
     * insert a target world in a given Trie tree.
     *
     * @param root root node of this tree.
     * @param word target word.
     * @return false if this word doesn't exist in this tree, true otherwise.
     */
    public static boolean insert(TrieNode root, String word) {
        if (search(root, word)) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
            cur.count++;
        }
        cur.isEnd = true;
        return true;
    }

    /**
     * delete a target word in a given Trie tree.
     *
     * @param root root node of this tree.
     * @param word target word.
     * @return false if this word doesn't exist in this tree.
     */
    public static boolean delete(TrieNode root, String word) {
        if (!search(root, word)) {
            return false;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next.count == 1) {
                cur.children.remove(word.charAt(i));
                return true;
            }
            cur = next;
            cur.count--;
        }
        cur.isEnd = false;
        return true;
    }
}