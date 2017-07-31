package LaiOffer;

import LaiOffer.HelperClass.ListNode;
import LaiOffer.HelperClass.Point;
import LaiOffer.HelperClass.TreeNode;
import LaiOffer.SortingAlgorithms.BucketSort;
import LaiOffer.SortingAlgorithms.CountingSort;
import LaiOffer.SortingAlgorithms.KSortedSort;

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
//
//        Integer i1 = 127;
//        Integer i2 = 128;
//
//        System.out.println(i1 < i2);

//        Character[][] m = (Character) gym;
//        int[] x = {-1, -1};

        Point p0 = new Point(1, 1);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
//        Point p3 = new Point(3, 3);
        Point[] points = {p0, p1, p2};


//        Integer[][] y = new Integer[2][2];
//        ph.printMatrix(solu.canMerge("abgcd", "bebgf", "abgcdbebgf"));

//        char[][] matrix = new char[][]{
//                {'A', 'B', 'E', 'D'},
//                {'E', 'E', 'E', 'G'},
//                {'E', 'I', 'H', 'I'},
//                {'J', 'K', 'L', 'M'}};

//        for (int[] array : solu.generateMatrix(3)) {
//            System.out.println(Arrays.toString(array));
//        }solu.printBST(, 14););

//        TreeNode t = TreeNode.levelOrderReconstruct(new String[]{"-1", "0", "1"});
//        printTree(t);

//        System.out.println(t.key);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        int[][] matrix1 = new int[][]{
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1}};
//
//        System.out.println(solu.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(solu.minWindow("aaacbc", "ab"));
//        System.out.println(solu.isAnagram("a", "a"));
//        System.out.println(0 % 0);

//        String[] array = new String[]{"/a/./b/../../c/", "/home/", "/abc/..."};
//        for (String s : array) {
//
//        }

//        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

        int[] array = new int[]{1, 2, 3};
//        solu.sortColors(array);
        System.out.println(solu.subsets(array).size());
//        for (int[] array : matrix) {
//            System.out.println(Arrays.toString(array));
//        }
//        for (TreeNode t : solu.convertBST(TreeNode.levelOrderReconstruct(}))) {
//            System.out.println(t.key);
//        }


//        System.out.println(solu.twoSumBST(new TreeNode(Integer.MAX_VALUE)));

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
//        int[] in = {1, 3, 4, 5, 8, 11};
//        int[] post = {1, 4, 3, 11, 8, 5};
//

//
//        int[] A = new int[] {1, 3, 5};
//        int[] B = new int[]{4, 8};
//        for (int i = 1; i <= 20; i++) {
//            System.out.println("factory (" + i + ") = " + solu.factory(i));
//        }
//        String[] array = new String[]{"4", "#", "6", "1", "5", "#", "#"};
//        System.out.println(TreeNode.levelOrderReconstruct(array));
    }
}
