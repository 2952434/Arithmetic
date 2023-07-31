package leetcode.其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ljx
 * @Date: 2022/6/23 8:51
 * @role:
 */
public class 串联所有单词的子串 {
    public static void main(String[] args) {
        findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"});
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int length = words[0].length();
        int length1 = length* words.length;
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> mapCopy = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        c:for (int i = 8; i < s.length()&&i+length1<s.length()+1; i++) {
            mapCopy.putAll(map);
            int i1 = i;
            for (int j = 0; j < words.length; j++) {
                String substring = s.substring(i1, i1 + length);
                i1+=length;
                if (mapCopy.containsKey(substring)) {
                    if (mapCopy.get(substring)==0){
                        continue c;
                    }else {
                        mapCopy.put(substring,mapCopy.get(substring)-1);
                    }
                }else {
                    continue c;
                }
            }
            list.add(i);
        }
        return list;
    }
}
