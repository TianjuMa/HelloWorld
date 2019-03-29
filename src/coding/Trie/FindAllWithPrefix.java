package coding.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * One implementation of method, which can find all words with same prefix for a give word.
 */
public class FindAllWithPrefix {
    public static List<String> findAllWithPrefix(TrieNode root, String targetPrefix) {
        if (root == null || targetPrefix == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        for (int i = 0; i < targetPrefix.length(); i++) {
            sb.append(targetPrefix.charAt(i));
            TrieNode next = cur.children.get(targetPrefix.charAt(i));
            if (next != null) {
                cur = next;
            } else {
                return null;
            }
        }
        findAllWithPrefixDFSHelper(cur, result, sb);
        return result;
    }

    private static void findAllWithPrefixDFSHelper(TrieNode root, List<String> result, StringBuilder sb) {
        if (root.isEnd) {
            result.add(sb.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            sb.append(entry.getKey());
            findAllWithPrefixDFSHelper(entry.getValue(), result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
