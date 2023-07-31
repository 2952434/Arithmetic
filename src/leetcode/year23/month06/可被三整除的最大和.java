package leetcode.year23.month06;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2023/6/19 11:46
 * @role:
 */
public class 可被三整除的最大和 {

    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int num = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i] % 3;
            if (x == 0) {
                num += nums[i];
            }else {
                List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(nums[i]);
                map.put(x,list);
            }
        }
        return num;
    }

}
