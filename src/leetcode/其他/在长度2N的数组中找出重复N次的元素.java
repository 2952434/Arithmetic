package leetcode.其他;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2022/5/21 19:05
 * @role:
 */
public class 在长度2N的数组中找出重复N次的元素 {
    public static void main(String[] args) {

    }
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
