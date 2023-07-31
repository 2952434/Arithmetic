package day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/4/6 19:33
 * @role:
 */
public class 题4_动态规划_LCS最长公共子序列 {

    public static void main(String[] args) {
        List<Character> dfs = dfs("asdfghjkl", "asvnakjfjldd");
        System.out.println(dfs.toString());
    }

    static List<Character> dfs(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        List<Character> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            //求以i字符开头的公共子序列
            List<Character> list = new ArrayList<>();
            //和s2的每个字符比较
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    list.add(s1.charAt(i));
                    list.addAll(dfs(s1.substring(i+1),s2.substring(j+1)));
                    break;
                }
            }
            if (list.size()>ans.size()){
                ans = list;
            }
        }
        return ans;
    }
}
