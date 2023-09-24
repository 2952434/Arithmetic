package leetcode.year23.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2023/8/26 18:31
 * @role:
 */
public class 汇总区间 {


    public List<String> summaryRanges(int[] nums) {
        List<String> ren = new ArrayList<>();
        if (nums.length == 0) {
            return ren;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end++;
            } else {
                if (start == end) {
                    ren.add(String.valueOf(start));
                } else {

                    ren.add(start + "->" + end);
                }
                end = nums[i];
                start = nums[i];
            }
        }
        if (start == end) {
            ren.add(String.valueOf(start));
        } else {

            ren.add(start + "->" + end);
        }
        return ren;
    }
}
