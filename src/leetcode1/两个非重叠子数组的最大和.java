package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2023/3/24 9:03
 * @role: https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class 两个非重叠子数组的最大和 {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]) {
            ++i;
        }
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            --j;
        }
        if (i >= j) {
            return 0;
        }
        int ans = Math.min(n - i - 1, j);
        for (int l = 0, r = j; l <= i; ++l) {
            while (r < n && arr[r] < arr[l]) {
                ++r;
            }
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{2,2,2,1,1,1}));
    }
}
