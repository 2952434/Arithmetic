package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2022/3/31 21:44
 * @role: https://www.bilibili.com/video/BV1VU4y1b7cG?p=113&spm_id_from=pageDriver
 */
public class 题5_对字符串进行全排列 {

    public static void main(String[] args) {

        System.out.println(getPermutation("asfd"));
        System.out.println(getPermutation01("asfd",3));
    }

    static List<String> getPermutation(String s){
        int n = s.length();
        List<String> res = new ArrayList<>();
        res.add(s.charAt(0)+"");

        for (int i = 1; i < n; i++) {
            List<String> resNew = new ArrayList<>();
            char c = s.charAt(i);
            for (String re : res) {
                String newStr = c + re;
                resNew.add(newStr);
                newStr = re + c;
                resNew.add(newStr);
                for (int j = 1; j < re.length(); j++) {
                    newStr = re.substring(0,j)+c+re.substring(j);
                    resNew.add(newStr);
                }
            }
            res = resNew;
        }
        return res;
    }

    static List<String> getPermutation01(String str,int n){
        List<String> list = new ArrayList<>();
        if (n==0){
            list.add(str.charAt(n)+"");
            return list;
        }
        List<String> oldList = getPermutation01(str, n - 1);
        for (String s : oldList) {
            String newStr = s+str.charAt(n);
            list.add(newStr);
            newStr = str.charAt(n)+s;
            list.add(newStr);
            for (int i = 1; i < s.length(); i++) {
                newStr = s.substring(0,i)+str.charAt(n)+s.substring(i);
                list.add(newStr);
            }
        }
        return list;
    }
}
