package leetcode.其他;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/4/28 10:52
 * @role:
 */
public class 按奇偶排序数组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
    }
    public static int[] sortArrayByParity(int[] nums) {
        int[] arr = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2==0){
                arr[left++] = nums[i];
            }else {
                arr[right--] = nums [i];
            }
        }
        return arr;
    }
}
