package leetcode.其他;

import java.util.Arrays;


/**
 * @Author: Ljx
 * @Date: 2022/6/28 16:02
 * @role:
 */
public class 摆动排序II {
    public static void main(String[] args) {
        wiggleSort(new int[]{1,4,3,4,1,2,1,3,1,3,2,3,3});
    }
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (i%2==1){
                int j = i+1;
                while (nums[i]>=nums[j]){
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else {
                int j = i+1;
                if (nums[i]>=nums[j]){

                }
            }
        }
    }
}
