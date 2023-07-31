package leetcode1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2023/4/5 10:15
 * @role: https://leetcode.cn/problems/number-of-common-factors/
 */
public class 公因子的数目 {
    public int commonFactors(int a, int b) {
        int min = Math.min(a,b);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(min);
        int pow = (int)Math.pow(min, 0.5);
        for (int i = 2; i <= pow; i++) {
            if (min%i==0){
                set.add(i);
                set.add(min/i);
            }
        }
        int max = Math.max(a,b);
        int num = 0;
        for (Integer s : set) {
            if (max % s ==0){
                num ++;
            }
        }
        return num;
    }
}
