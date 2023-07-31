package leetcode.其他;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Ljx
 * @Date: 2022/4/25 19:37
 * @role: https://leetcode-cn.com/problems/random-pick-index/
 */

class Solution1 {
    int[] arr ;
    public Solution1(int[] nums) {
        arr = nums;
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target){
                list.add(i);
            }
        }
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

public class 随机数索引 {

    public static void main(String[] args) {
//        Solution1 Solution1 = new Solution1(new int[]{1,4,3,4,5});
//        System.out.println(Solution1.pick(4));
    }
}
