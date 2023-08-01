package leetcode.year23.month07;

import java.util.Arrays;

public class 删除每行最大值 {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int res = 0;
        for (int j = grid[0].length -1; j >= 0; j--) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max(ints[j], max);
            }
            res += max;
        }
        return res;
    }
}
