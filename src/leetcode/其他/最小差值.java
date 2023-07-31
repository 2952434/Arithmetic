package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/4/30 16:44
 * @role:
 */
public class 最小差值 {
    public static void main(String[] args) {

    }
    public static int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        return Math.max((max - min - 2 * k), 0);
    }
}
