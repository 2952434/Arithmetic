package leetcode1;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: Ljx
 * @Date: 2023/5/15 9:14
 * @role:
 */
public class 按列翻转得到最大值等行数 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int[] dp = new int[matrix[0].length];
        Arrays.fill(dp,-1);
        return maxEqualRowsAfterFlips(matrix,0,dp);
    }
    public int maxEqualRowsAfterFlips(int[][] arr,int j,int[] dp) {
        if (j >= arr[0].length) {
            return equalRows(arr);
        }
        if (dp[j]!=-1) {
            return dp[j];
        }
        int rows1 = maxEqualRowsAfterFlips(arr, j + 1,dp);
        flips(arr,j);
        int rows2 = maxEqualRowsAfterFlips(arr, j + 1,dp);
        flips(arr,j);
        dp[j] = Math.max(rows1,rows2);
        return dp[j];
    }

    public void flips(int[][] arr,int j) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][j] = arr[i][j] == 0 ? 1 : 0;
        }
    }

    public int equalRows(int[][] arr){
        int rows = 0;
        c:for (int[] ints : arr) {
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] != ints[j + 1]) {
                    continue c;
                }
            }
            rows++;
        }
        return rows;
    }
}
