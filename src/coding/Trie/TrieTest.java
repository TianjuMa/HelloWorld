package coding.Trie;

/**
 * Created by matinaju on 7/2/17.
 */
public class TrieTest {
    public static void main(String[] args) {
//        String[] dic = {"a", "ab"};
//        TrieNode root = TrieNode.buildTrie(dic);
//        System.out.println(TrieNode.search(root, "laowang"));
//        TrieNode.insert(root, "capacity");
//        TrieNode.insert(root, "city");
//        System.out.println(TrieNode.search(root, "apple"));
//        System.out.println(TrieNode.delete(root, "apple"));
//        System.out.println(TrieNode.search(root, "apple"));
//        System.out.println(FindAllWithPrefix.findAllWithPrefix(root, "c"));
//        System.out.println(WildCard.findAllMatchWildCard(dic, "ca?"));
//        char[][] matrix = {
//                {'a', 'p', 'p', 'd'},
//                {'p', 'p', 'l', 'g'},
//                {'o', 'g', 'e', 'i'},
//                {'d', 'k', 'l', 'm'}};
//
//        System.out.println(BoggleGame.boggleGameNaive(matrix, dic));
//        System.out.println(BoggleGame.BoggleGameOptimized(matrix, dic));

//        WildCard wc = new WildCard();
//        System.out.println(wc.isMatch("aab", "c*a*b"));
//        System.out.println(wc.isMatch("c", "*?*"));

//        WordDictionary wordDic = new WordDictionary();
//        for (String s : dic) {
//            wordDic.addWord(s);
//        }
////        System.out.println(wordDic.search("bad"));
////        System.out.println(wordDic.search(".ad"));
////        System.out.println(wordDic.search("b.."));
//        System.out.println(wordDic.search("a"));
//        System.out.println(wordDic.search("."));
//        System.out.println(wordDic.search("a."));

        Trie t = new Trie();
        System.out.println(t.search("a"));
        t.insert("a");
        System.out.println(t.search("a"));
    }
}
