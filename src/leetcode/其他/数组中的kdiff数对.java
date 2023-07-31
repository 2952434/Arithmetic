package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/6/16 8:19
 * @role:
 */
public class 数组中的kdiff数对 {
    public static void main(String[] args) {
        findPairs(new int[]{3,2,1},3);
    }
    public static int findPairs(int[] nums, int k) {
        int rtn = 0;
        if (k==0){
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1>2?map.getOrDefault(num,0):map.getOrDefault(num,0)+1);
            }
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                rtn += map.get(iterator.next())/2;
            }
            return rtn;
        }


        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (Math.abs(list.get(i)-list.get(j))==k){
                    rtn++;
                }
            }
        }
        return rtn;
    }
}
