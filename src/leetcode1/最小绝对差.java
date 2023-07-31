package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/7/4 8:23
 * @role:
 */
public class 最小绝对差 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list ;
        for (int i = 0; i < arr.length-1; i++) {
            if (Math.abs(arr[i]-arr[i+1])<min){
                lists.clear();
                min = Math.abs(arr[i]-arr[i+1]);
                list =new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                lists.add(list);
            }else if (Math.abs(arr[i]-arr[i+1])==min){
                list =new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                lists.add(list);
            }
        }
        return lists;
    }
}
