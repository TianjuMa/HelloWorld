package coding.Trie;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
public class WordDictionary {
    private class TrieNodeII {
        TrieNodeII[] children = new TrieNodeII[26];
        boolean isEnd = false;
    }

    private TrieNodeII root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNodeII();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNodeII cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNodeII();
            }
            cur = cur.children[word.charAt(i) - 'a'];
            if (i == word.length() - 1) {
                cur.isEnd = true;
            }
        }
    }

    /**
     * Returns if the word is in the data structure. A word could
     * contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNodeII root, String word, int index) {
        if (index == word.length()) {
            return root.isEnd;
        }
        if (word.charAt(index) != '.') {
            TrieNodeII next = root.children[word.charAt(index) - 'a'];
            return next != null && search(next, word, index + 1);
        } else {
            for (TrieNodeII t : root.children) {
                if (t != null && search(t, word, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

