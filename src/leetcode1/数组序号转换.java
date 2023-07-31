package leetcode1;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/7/27 20:38
 * @role:
 */
public class 数组序号转换 {

    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        int i = 1;
        Map<Integer,Integer> map = new HashMap<>();
        while (iterator.hasNext()){
            map.put(iterator.next(),i++);
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            arr[i1] = map.get(arr[i1]);
        }
        return arr;
    }
}

