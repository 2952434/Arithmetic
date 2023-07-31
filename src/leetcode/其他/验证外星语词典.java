package leetcode.其他;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ljx
 * @Date: 2022/5/17 23:19
 * @role:
 */
public class 验证外星语词典 {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        if (words.length==1){
            return true;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        c:for (int i = 0; i < words.length-1; i++) {
            String word = words[i + 1];
            for (int j = 0; j < word.length()&&j<words[i].length(); j++) {
                if (map.get(words[i].charAt(j))>map.get(word.charAt(j))){
                    return false;
                }else if (map.get(words[i].charAt(j))<map.get(word.charAt(j))){
                    continue c;
                }
            }
            if (words[i].length()>word.length()){
                return false;
            }
        }
        return true;
    }
}
