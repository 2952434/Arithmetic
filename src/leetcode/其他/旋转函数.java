package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/4/22 19:53
 * @role: https://leetcode-cn.com/problems/rotate-function/
 */
public class 旋转函数 {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public static int maxRotateFunction(int[] nums) {
        int he = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max += i*nums[i];
            he += nums[i];
        }
        int y = max;
        for (int i = 1; i < nums.length; i++) {
            y += (nums.length-1) * nums[i - 1] - he - nums[i-1];
            max = Math.max(max,y);
        }
        return max;
    }
}
