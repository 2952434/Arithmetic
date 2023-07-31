package leetcode.其他;

import java.util.Locale;

/**
 * @Author: Ljx
 * @Date: 2022/4/21 8:04
 * @role: https://leetcode-cn.com/problems/goat-latin/
 */
public class 山羊拉丁文 {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public static String toGoatLatin(String sentence) {
        //定义返回结果
        StringBuilder res = new StringBuilder();
        //定义累加字符串
        StringBuilder string = new StringBuilder("maa");
        for (int i = 0; i < sentence.length(); i++) {
            //将每个单词第一个字符转换为小写字符串
            String s = String.valueOf(sentence.charAt(i)).toLowerCase();
            //找到下一个空格位置
            int i1 = sentence.indexOf(" ", i);
            //判断每个单词第一个字符是否为元音字母
            boolean judge = "a".equals(s) || "e".equals(s) || "i".equals(s) || "o".equals(s) || "u".equals(s);
            if (i1 != -1) { //如果找到下一个空格位置执行以下操作

                if (judge) { //如果是元音字母

                    res.append(sentence, i, i1);
                } else { //如果不是元音字母

                    res.append(sentence, i + 1, i1);
                    //将单词第一个字母添加到末尾
                    res.append(sentence.charAt(i));
                }
                //添加后缀
                res.append(string);
                //指针移动到下一个字母
                i = i1;
            }else {
                //如果没有找到下一个空格位置执行以下操作
                if (judge) { //如果是元音字母

                    res.append(sentence.substring(i));
                } else { //如果不是元音字母
                    res.append(sentence.substring(i+1));
                    //将单词第一个字母添加到末尾
                    res.append(sentence.charAt(i));
                }
                //添加后缀
                res.append(string);
                return res.toString();
            }
            // 结果加空格
            res.append(" ");
            //后缀加“a”
            string.append("a");
        }
        return res.toString();
    }
}
