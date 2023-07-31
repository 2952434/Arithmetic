package leetcode.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/4/19 16:27
 * @role: https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
public class 字符的最短距离 {
    public static void main(String[] args) {

    }
    public static int[] shortestToChar(String s, char c) {
        int[] arr = new int[s.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c){
                list.add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (Integer integer : list) {
                min = Math.min(min,Math.abs(integer-i));
            }
            arr[i] = min;
        }
        return arr;
    }
}
