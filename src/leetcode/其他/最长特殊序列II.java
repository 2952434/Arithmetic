package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/6/27 10:29
 * @role:
 */
public class 最长特殊序列II {
    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"11", "1", "123"}));
    }

    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (int i = 0; i < strs.length; i++) {
            if (!isSubSeqOfAnother(strs, i)) {
                return strs[i].length();
            }
        }
        return -1;
    }

    static boolean isSubSeqOfAnother(String strs[], int idx) {
        for (int i = 0; i < strs.length; i++) {
            if (i == idx) {
                continue;
            }
            if (strs[i].length() < strs[idx].length()) {
                break;
            }
            if (isSubSeq(strs[idx], strs[i])) {
                return true;
            }
        }
        return false;
    }

    static boolean isSubSeq(String s1, String s2) {
        //判断s1是否为s2的子序列
        int p1 = 0, p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            while (p2 < s2.length() && s2.charAt(p2) != s1.charAt(p1)) {
                p2++;
            }
            if (p2 < s2.length()) {
                p1++;
            }
            p2++;
        }
        return p1 == s1.length();
    }

    public static boolean judge(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (j == s2.length()) {
                return false;
            }
            while (c != s2.charAt(j)) {
                j++;
                if (j == s2.length()) {
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
