package day04;

/**
 * @Author: Ljx
 * @Date: 2022/3/31 9:22
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=109
 */

/**
 * 假设我们有8种不同的值的硬币{1，2，5，10，20，50，100，200}，用这些硬币组合构成一个给定的数值n。
 * 例如n=200，那么一种可能的组合方式为 200 = 3 * 1 + 1*2 + 1*5 + 2*20 + 1*50 + 1*100.
 * 问总共有多少种可能的组合方式？（这道题目来自著名变成网站ProjectEuler）类似的题目还有：
 *
 *     [华为面试题] 1分2分5分的硬币三种，组合成1角，共有多少种组合
 *     1*x + 2*y + 5*z = 10
 *     [创新工厂笔试题] 有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱，有多少种组合可以组成n分钱
    1 5 10 25 分 n，多少种组合方法
 */
public class 题2_硬币表示某个数值 {
    public static void main(String[] args) {

        for (int i = 0; i < 101; i++) {
            System.out.println(i+">>>>>"+countWays(i));
            System.out.println(i+">>>>>"+countWays1(i));
            System.out.println(i+">>>>>"+countWays2(i));
        }
    }

    /**
     * 递归形式
     * @param n
     * @return
     */
    static int countWays(int n){
        if (n<=0){
            return 0;
        }
        return countWaysCore(n,new int[]{1,5,10,25}, 3);
    }
    static int countWaysCore(int n,int[] coins,int cur){
        if (cur==0){
            return 1;
        }
        int res = 0;
        for (int i = 0; i*coins[cur] <= n; i++) {
            int shengyu = n-i*coins[cur];
            res += countWaysCore(shengyu,coins,cur-1);
        }
        return res;
    }


    /*递推解法*/
    static int countWays1(int n) {

        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[4][n + 1];//前i种面值,组合出面值j
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;//凑出面值0,只有一种可能,第一列初始化为1
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 1;//用1来凑任何面值都只有一种凑法,第一行初始化为1
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 0; k <= j / coins[i]; ++k) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[3][n];
    }

    /*递推解法*/
    static int countWays2(int n) {

        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = coins[i]; j < n + 1; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
