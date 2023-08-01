package leetcode.year23.month07;

import java.util.Arrays;

public class 下降路径最小和 {

    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return minFalling(matrix, 0, 0,dp);
    }

    public int minFalling(int[][] arr, int row, int col, int[][] dp) {
        if (row == arr.length) {
            return 0;
        } else if (col < 0 || col == arr.length) {
            return Integer.MAX_VALUE;
        }
        if (row == 0) {
            int ren = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = -1; j <= 1; j++) {
                    min = Math.min(minFalling(arr, row + 1, i + j, dp), min);
                }
                ren = Math.min(min + arr[row][col + i], ren);
            }
            return ren;
        } else {
            if (dp[row][col] == Integer.MAX_VALUE){
                int min = Integer.MAX_VALUE;
                for (int i = -1; i <= 1; i++) {
                    min = Math.min(minFalling(arr, row + 1, col + i, dp), min);
                }
                dp[row][col] = min + arr[row][col];
            }
            return dp[row][col];
        }
    }

    public static void main(String[] args) {
        下降路径最小和 test = new 下降路径最小和();
        System.out.println(test.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 1, dp[0], 1, n-1);
        System.out.println(Arrays.toString(dp[0]));
    }




}
