package leetcode.剑指OfferII091;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/6/25 16:46
 * @role:
 */
public class 粉刷房子 {

    public int minCost(int[][] costs) {
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = costs[1][i];
        }

        for (int i = 1; i < costs.length; i++) {
            int[] dp = new int[3];
            for (int i1 = 0; i1 < 3; i1++) {
                dp[i1] = Math.min(arr[(i1+1)%3],arr[(i1+2)%3])+costs[i][i1];
            }
            arr =dp;
        }
        return Arrays.stream(arr).min().getAsInt();
    }


}
