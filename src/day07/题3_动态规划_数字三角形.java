package day07;

import java.util.Scanner;

/**
 * @Author: Ljx
 * @Date: 2022/4/5 8:03
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=137
 */
public class 题3_动态规划_数字三角形 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSunUsingRecursive(triangle,0,0));
        System.out.println(maxSunUsingDp(triangle,0,0));
        System.out.println(maxSunUsingDp1(triangle,0,0));

    }


    /**
     * 递归
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    static int maxSunUsingRecursive(int[][] triangle, int i, int j) {
        int rowIndex = triangle.length;
        if (i==rowIndex-1){
            return triangle[i][j];
        }else {
            return triangle[i][j] + Math.max(maxSunUsingRecursive(triangle, i+1, j),maxSunUsingRecursive(triangle, i+1, j+1));
        }
    }

    /**
     * 二维数组保存
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    static int maxSunUsingDp(int[][] triangle, int i, int j) {
        //行数
        int rowCount = triangle.length;
        //最后一行的列数
        int columnCount = triangle[rowCount-1].length;
        int[][] dp = new int[rowCount][columnCount];
        for (int k = 0; k < columnCount; k++) {
            //初始化最后一行
            dp[rowCount-1][k] = triangle[rowCount-1][k];
        }
        for (int k = rowCount - 2; k >= 0; k--) {
            for (int l = 0; l <= k; l++) {
                dp[k][l] = triangle[k][l] + Math.max(dp[k+1][l],dp[k+1][l+1]);
            }
        }
        return dp[0][0];
    }

    /**
     * 一维数组保存
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    static int maxSunUsingDp1(int[][] triangle, int i, int j) {
        //行数
        int rowCount = triangle.length;
        //最后一行的列数
        int columnCount = triangle[rowCount-1].length;
        int[] dp = new int[columnCount];
        for (int k = 0; k < columnCount; k++) {
            //初始化最后一行
            dp[k] = triangle[rowCount-1][k];
        }
        for (int k = rowCount - 2; k >= 0; k--) {
            for (int l = 0; l <= k; l++) {
                dp[l] = triangle[k][l] + Math.max(dp[l],dp[l+1]);
            }
        }
        return dp[0];
    }
}
