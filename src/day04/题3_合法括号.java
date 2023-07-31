package day04;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Ljx
 * @Date: 2022/3/31 17:08
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=110&spm_id_from=333.1007.top_right_bar_window_history.content.click
 */

/**
 * 实现一种算法，打印n对括号的全部有效组合（即左右括号正确配对)。
 */
public class 题3_合法括号 {

    public static void main(String[] args) {
        for (String s : parenthesis(5)) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s : parenthesis1(5)) {
            System.out.print(s+" ");
        }
    }

    /**
     * 递归形式
     * @param n
     * @return
     */
    static Set<String> parenthesis(int n){
        Set<String> res = new HashSet<>();
        if (n==1){
            res.add("()");
            return res;
        }
        Set<String> set = parenthesis(n-1);
        for (String s : set) {
            res.add(s+"()");
            res.add("()"+s);
            res.add("("+s+")");
        }
        return res;
    }

    /**
     * 迭代形式
     * @param n
     * @return
     */
    static Set<String> parenthesis1(int n){
        Set<String> res = new HashSet<>();
        res.add("()");
        if (n==1){
            return res;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> resNew = new HashSet<>();
            for (String e : res) {
                resNew.add(e+"()");
                resNew.add("()"+e);
                resNew.add("("+e+")");
            }
            res = resNew;
        }
        return res;
    }
}
