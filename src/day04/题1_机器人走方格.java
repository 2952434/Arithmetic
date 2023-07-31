package day04;

/**
 * @Author: Ljx
 * @Date: 2022/3/31 8:50
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=108&spm_id_from=pageDriver
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x+y小于等于12。
 */
public class 题1_机器人走方格 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        arr = new int[x + 1][y + 1];
        for (int[] ints : arr) {
            Arrays.fill(ints, -1);
        }
        System.out.println(solve(x, y));
        System.out.println(solve1(x, y));
        System.out.println(solve2(x, y));
    }

    /**
     * 递归方法 有大量重复计算 可用记忆性递归优化
     *
     * @param x x轴
     * @param y y轴
     * @return int
     */
    static int solve(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return solve(x - 1, y) + solve(x, y - 1);
    }


    static int[][] arr;

    /**
     * 记忆性递归形式
     *
     * @param x x轴
     * @param y y轴
     * @return int
     */
    static int solve1(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        if (arr[x][y] != -1) {
            return arr[x][y];
        }
        arr[x][y] = solve1(x - 1, y) + solve1(x, y - 1);
        return arr[x][y];
    }

    /**
     * 递推方法
     *
     * @param m x轴
     * @param n y轴
     * @return int
     */
    static int solve2(int m, int n) {
        int[][] state = new int[m + 1][n + 1];
        //初始化第一行
        for (int i = 1; i <= n; i++) {
            state[1][i] = 1;
        }
        //初始化第一列
        for (int i = 1; i <= m; i++) {
            state[i][1] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                state[i][j] = state[i][j - 1] + state[i - 1][j];
            }
        }
        return state[m][n];
    }
}
