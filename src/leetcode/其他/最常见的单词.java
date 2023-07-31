package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/4/17 8:39
 * @role: https://leetcode-cn.com/problems/most-common-word/
 */
public class 最常见的单词 {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
//        将banned中的单词添加到set集合中
        Set<String> set = new HashSet<>(Arrays.asList(banned));
//        定义Map集合
        Map<String,Integer> map = new TreeMap<>();
        int start = 0;
//        将paragraph中大写字母转为小写字母
        paragraph = paragraph.toLowerCase();
        for (int end = 0; end < paragraph.length(); end++) {
//            如果遍历到最后且最后一个字符为字母执行下面操作
            if (end==paragraph.length()-1){
                if (paragraph.charAt(end)<'z'&&paragraph.charAt(end)>'a'){
                    String substring = paragraph.substring(start);
                    if (!set.contains(substring)){
                        map.put(substring,map.getOrDefault(substring,0)+1);
                    }
                }
            }
//            遍历到的字符不是字母执行下面操作
            if (paragraph.charAt(end)>'z'||paragraph.charAt(end)<'a'){
//                截取字符串
                String substring = paragraph.substring(start, end);
//                判断该字符串是否在set集合中
                if (!set.contains(substring)){
//                    如果不在添加到map集合中
                    map.put(substring,map.getOrDefault(substring,0)+1);
                }
//                将指针后移
                while (end<paragraph.length()&&(paragraph.charAt(end)>'z'||paragraph.charAt(end)<'a')){
                    end++;
                    start = end;
                }
            }
        }
        int x = 0;
        String y = "";
//        遍历map集合找到value最大的字符串
        for (String key : map.keySet()) {
            if (map.get(key)>x){
                y = key;
                x = map.get(key);
            }
        }
//        返回字符串
        return y;
    }
}
