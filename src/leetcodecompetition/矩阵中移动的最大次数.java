package leetcodecompetition;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2023/5/14 11:10
 * @role:
 */
public class 矩阵中移动的最大次数 {

    public static int maxMoves(int[][] grid) {
        int max = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max,maxMoves(grid,i,0,grid[i][0],dp));
        }
        return max - 1 ;
    }


    public static int maxMoves(int[][] arr,int i,int j,int beforeValue,int[][] dp) {
        if (i < 0 || i >= arr.length || j >= arr[i].length) {
            return 0;
        }
        if (j != 0 && arr[i][j] <= beforeValue){
            return 0;
        }
        int max;
        if (dp[i][j] == -1) {
            max = Math.max(maxMoves(arr, i + 1, j + 1, arr[i][j], dp), Math.max(maxMoves(arr, i - 1, j + 1, arr[i][j], dp), maxMoves(arr, i, j + 1, arr[i][j], dp))) + 1;
            dp[i][j] = max;
        }else {
            max = dp[i][j];
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(maxMoves(new int[][]{new int[]{2, 4, 3, 5}, new int[]{5, 4, 9, 3}, new int[]{3, 4, 2, 11}, new int[]{10, 9, 13, 15}}));
    }


}
