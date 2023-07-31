package day07;

/**
 * @Author: Ljx
 * @Date: 2022/4/4 22:11
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=135&spm_id_from=pageDriver
 */
public class 题1_动态规划_背包问题 {

    static int[] w = {2,1,3,2};
    static int[] v = {3,2,4,2};
    /**
     * 物品数量
     */
    static int n = 4;
    /**
     * 背包的承重极限
     */
    static int W = 5;

    public static void main(String[] args) {
        System.out.println(dp());
    }

    private static int dp() {
        int[][] dp = new int[n][W+1];
        //初始化dp表的第一行
        for (int i = 0; i < W + 1; i++) {
            //i是背包的容量
            if (i>=w[0]){
                dp[0][i] = v[0];
            }else {
                dp[0][i] = 0;
            }
        }
        //其他行
        for (int i = 1; i < n; i++) {
            //j是列，也是背包剩余的容量
            for (int j = 0; j < W + 1; j++) {
                if (j>=w[i]){
                    //选择当前物品即i号物品，剩余容量
                    int i1 = v[i] + dp[i-1][j-w[i]];
                    int i2 = dp[i-1][j];
                    dp[i][j] = Math.max(i1,i2);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][W];
    }


}
