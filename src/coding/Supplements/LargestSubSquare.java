package coding.Supplements;

/**
 * Created by matinaju on 6/26/17.
 */
public class LargestSubSquare {
    public int largestSubSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] rightToLeft = processRightLeft(matrix);
        int[][] bottomToUp = processBottomToUp(matrix);
        int maxPossibleEdge = Math.min(matrix.length, matrix[0].length);
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int edgeLength = 1; edgeLength <= maxPossibleEdge; edgeLength++) {
                    if (isValidLength(rightToLeft, bottomToUp, edgeLength, i, j)) {
                        max = Math.max(max, edgeLength);
                    }
                }
            }
        }
        return max;
    }

    private boolean isValidLength(int[][] rightToLeft, int[][] bottomToUp, int edgeLength, int row, int col) {
        if (row + edgeLength > rightToLeft.length || col + edgeLength > rightToLeft[0].length) {
            return false;
        }
        return topLeft(rightToLeft, bottomToUp, edgeLength, row, col) && bottomLeft(rightToLeft, edgeLength, row, col) && topRight(bottomToUp, edgeLength, row, col);
    }

    private int[][] processRightLeft(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = j == matrix[0].length - 1 ? 1 : result[i][j + 1] + 1;
                }
            }
        }
        return result;
    }

    private int[][] processBottomToUp(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = i == matrix.length - 1 ? 1 : result[i + 1][j] + 1;
                }
            }
        }
        return result;
    }

    private boolean topLeft(int[][] rightToLeft, int[][] bottomToUp, int edgeLength, int row, int col) {
        return rightToLeft[row][col] >= edgeLength && bottomToUp[row][col] >= edgeLength;
    }

    private boolean bottomLeft(int[][] rightToLeft, int edgeLength, int row, int col) {
        return rightToLeft[row + edgeLength - 1][col] >= edgeLength;
    }

    private boolean topRight(int[][] bottomToUp, int edgeLength, int row, int col) {
        return bottomToUp[row][col + edgeLength - 1] >= edgeLength;
    }
}
