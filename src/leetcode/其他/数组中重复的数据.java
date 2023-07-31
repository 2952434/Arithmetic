package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/5/8 10:27
 * @role: https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/solution/shu-zu-zhong-zhong-fu-de-shu-ju-by-leetc-782l/
 */
public class 数组中重复的数据 {
    public static void main(String[] args) {
        findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i!=nums[i]-1){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

     public static List<Integer> findDuplicates1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
         for (int i = 0; i < n; i++) {
             int x = Math.abs(nums[i]);
             if (nums[x-1]>0){
                 nums[x-1] = -nums[x-1];
             }else {
                 list.add(x);
             }
         }
         return list;
     }
}
