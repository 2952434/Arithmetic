package leetcode.其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ljx
 * @Date: 2022/6/12 14:52
 * @role:
 */
public class 查找和替换模式 {
    public static void main(String[] args) {

    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String pattern1 = Pattern(pattern);
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (Pattern(word).equals(pattern1)){
                list.add(word);
            }
        }
        return list;
    }
    public String Pattern(String s){
        Map<Character,Integer> map = new HashMap<>();
        int x = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                stringBuilder.append(x);
                map.put(s.charAt(i),x++);
            }else {
                stringBuilder.append(map.get(s.charAt(i)));
            }
        }
        return stringBuilder.toString();
    }
}
