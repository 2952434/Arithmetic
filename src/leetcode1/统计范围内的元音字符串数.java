package leetcode1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2023/6/2 8:16
 * @role:
 */
public class 统计范围内的元音字符串数 {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int num = 0;
        int[] arr = new int[words.length];
        String set = "aeiou";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (set.contains(String.valueOf(word.charAt(0))) && set.contains(String.valueOf(word.charAt(word.length()-1)))){
                num++;
            }
            arr[i] = num;
        }
        int[] arr1 = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            arr1[i] = arr[end] - (start == 0 ? 0 : arr[start - 1]);
        }
        return arr1;
    }
}
