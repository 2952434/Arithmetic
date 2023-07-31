package leetcode.其他;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/6/13 8:39
 * @role:
 */
public class 高度检查器 {
    public static void main(String[] args) {
        高度检查器 he = new 高度检查器();
        he.heightChecker(new int[]{1,3,5,6,3});
    }
    public int heightChecker(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[m + 1];
        for (int h : heights) {
            ++cnt[h];
        }

        int idx = 0, ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= cnt[i]; ++j) {
                if (heights[idx] != i) {
                    ++ans;
                }
                ++idx;
            }
        }
        return ans;
    }
}
