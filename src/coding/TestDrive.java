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

//        String[] dict = new String[]{"abcde", "abcd", "ade", "xy"};

//        double[] array = new double[]{-5.0, -2.0, -1.0, -0.3};

//        System.out.println(solu.spiralOrder(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}}));
//        char[][] gym = new char[][]{
//                {'E', 'C', 'E', 'O', 'C'},
//                {'E', 'O', 'C', 'C', 'E'},
//                {'O', 'O', 'E', 'C', 'C'},
//                {'C', 'O', 'C', 'E', 'E'},
//                {'E', 'C', 'C', 'C', 'C'}};

        List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        EvenIterator ite1 = new EvenIterator(list);
//        while(ite1.hasNext()) {
//            System.out.println(ite1.next());
//        }
//        String[] root = new String[]{"1", "2", "3", "#", "15"};
//        for (int i = 1; i <= 10; i++) {
//
//        }
//        int[][] board = new int[][]{{1, 1}, {1, 0}};
//        solu.gameOfLife(board);
//        for (int[] a : board) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println(solu.isAdditiveNumber("199001200"));
//        System.out.println(solu.addOperators("232", 8));
//        System.out.println(solu.addOperators("105", 5));
//        System.out.println(solu.addOperators("00", 0));
//        System.out.println(solu.addOperators("3456237490", 9191));
//        System.out.println(solu.addOperators("1055", 100));
//        int[] arr = new int[]{0, 2, 3, 4, 6, 8, 9};
//        System.out.println(solu.summaryRanges(arr));
//        char[][] matrix = new char[][]{
//                {'1', '1', '1', '0'},
//                {'0', '0', '1', '0'},
//                {'0', '0', '1', '0'},
//                {'0', '0', '0', '0'}};

//        int[][] matrix1 = new int[][]{{1, 2, 3}, {2, 4, 5}, {6, 8, 10}};


//        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

        int[] array = new int[]{0};
        int[] array1 = new int[]{-2, 5, -1};
        int[] array2 = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0};
//        int[] array = new int[]{6, 7};
//        int[] array1 = new int[]{6, 0, 4};
        System.out.println(solu.countRangeSum(array, 0, 0));
        System.out.println(solu.countRangeSum(array1, -2, 2));
        System.out.println(solu.countRangeSum(array2, -1, 0));
//        System.out.println(solu.removeDuplicateLetters("cbacdcbc"));
//        char[][] gym = new char[][]{
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}};
//

//
//        String[] words3 = {"a", "b"};

//        System.out.println(solu.distance(TreeNode.levelOrderReconstruct(
//                new String[]{"7","3","9","1","5","8","10","#","2","4","6"}), 10, 4));
//        System.out.println(solu.topView(TreeNode.levelOrderReconstruct(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"})));

//        char[][] gym3 = new char[][]{
//                {'a','b'},
//                {'c','d'}};

//
//        double[][] matrix2 = new double[][]{
//                {1, -0.2, -1},
//
//                {1, -1.5, 1},
//
//                {0, 0, 1}};
////

//        char[][] gym = new char[][]{
//                {'E', 'E', ' ', ' ', ' '},
//                {' ', 'E', ' ', ' ', 'E'},
//                {' ', ' ', 'E', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' '}};
//        int[] in = {1, 4, 7, 11, 6, 2, -3, -8};
//        System.out.println(solu.search(in, 2));
//        int[] pre = {-2, 0, 6, 7, 8, 10};
//        System.out.println(solu.search(pre, 7));
//        int[] array1 = {1, 3, 5, 8, 6, 2};
//        System.out.println(solu.search(array1, 5));
//        int[] array2 = {-2, 0, 6, 7, 8, 10, 1};
//        System.out.println(solu.search(array2, 10));

//        System.out.println(solu.primes(2));
//        System.out.println(solu.primes(3));
//        int[][] input = new int[][]{{1, 7}, {2, 5}, {6, 20}, {4}};
//        int[][] input2 = new int[][]{{1, 4, 8, 9}, {2, 5, 8, 10}, {8, 20}, {8}};


//        System.out.println(solu.shortest("aabbbcccc", 3));
//        System.out.println(solu.shortest("aabcc", 4).length());
//        System.out.println(solu.shortest("abbda", 3));

    }
}
