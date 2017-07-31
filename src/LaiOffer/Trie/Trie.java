package LaiOffer.Trie;

public class Trie {
    private Trie root;
    private Trie[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = this;
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new Trie();
            }
            cur = cur.children[word.charAt(i) - 'a'];
            if (i == word.length() - 1) {
                cur.isEnd = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            Trie next = cur.children[word.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            cur = next;
            if (i == word.length() - 1) {
                return cur.isEnd;
            }
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Trie next = cur.children[prefix.charAt(i) - 'a'];
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return find(cur);
    }

    private boolean find(Trie root) {
        if (root.isEnd) {
            return true;
        }
        for (Trie t : root.children) {
            if (t != null && find(t)) {
                return true;
            }
        }
        return false;
    }
}

