package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/5/5 13:26
 * @role:
 */
public class 乘积小于K的子数组 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{1,2,3,4,5}, 19));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
