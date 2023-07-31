package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2023/4/21 10:46
 * @role:
 */
public class 最长的字母序连续子字符串的长度 {

    public int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int next = chars[0] - 'a';
        int m = 0;
        for (char c : chars) {
            if ((c - 'a') == next) {
                m++;
                next++;
            }else {
                max = Math.max(m,max);
                m = 1;
                next = (c - 'a') + 1;
            }
        }
        return max;
    }
}
