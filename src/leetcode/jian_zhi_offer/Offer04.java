package leetcode.jian_zhi_offer;

import java.util.Arrays;

/**
 *
 * @author zhenghuan
 * @date 2022/2/11
 */
public class Offer04 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{ { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(findNumberIn2DArray(arr, 5));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return findNumber(matrix, target, matrix.length - 1, 0);
    }

    public static boolean findNumber(int[][] arr, int target, int n, int m) {
        if (n < 0 || m > arr[0].length) {
            return false;
        } else if (arr[n][m] < target) {
            return findNumber(arr, target, n, ++m);
        } else if (arr[n][m] > target) {
            return findNumber(arr, target, --n, m);
        } else {
            return true;
        }
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
