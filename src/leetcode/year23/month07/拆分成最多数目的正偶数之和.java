package leetcode.year23.month07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class 拆分成最多数目的正偶数之和 {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        for (long i = 2; i < finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1,res.get(res.size() - 1) + finalSum);
        return res;
    }

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int ren = 0;
        for (int i = nums[0].length-1; i >=0 ; i--) {
            int max = 0;
            for (int[] num : nums) {
                max = Math.max(num[i], max);
            }
            ren += max;
        }
        return ren;
    }

}
