package leetcode1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2023/2/16 10:35
 * @role:
 */
public class 数组能形成多少数对 {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i1 = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                i1++;
            }else {
                set.add(num);
            }
        }
        return new int[]{i1,set.size()};
    }
}
