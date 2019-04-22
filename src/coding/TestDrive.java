package coding;

import coding.HelperClass.ListNode;
import coding.HelperClass.Point;
import coding.HelperClass.TreeNode;
import coding.MyIterators.EvenIterator;
import coding.SortingAlgorithms.BucketSort;
import coding.SortingAlgorithms.CountingSort;
import coding.SortingAlgorithms.KSortedSort;
import coding.Trie.BoggleGame;
import coding.Trie.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Test case for Solution class.
 */
public class TestDrive {
    public static void main(String[] args) {
        Solution solu = new Solution();

        String[] arr = new String[]{"4", "1", "5", "#", "#", "7", "6"};
        TreeNode root = TreeNode.levelOrderReconstruct(arr);
//        System.out.println(root);
        solu.inorder(root);

    }
}
