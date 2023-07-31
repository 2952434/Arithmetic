package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/5/7 16:18
 * @role:
 */
public class 最小基因变化 {
    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT","AACCGCTA",new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"} ));
    }
    public static int minMutation(String start, String end, String[] bank) {
        Set<String> strings = new HashSet<>();
        Collections.addAll(strings,bank);
        while (!strings.isEmpty()){
            int min  = Integer.MAX_VALUE;
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()){
                int x = 0;
                String next = iterator.next();
                for (int i = 0; i < start.length(); i++) {
                    if (start.charAt(i)!=next.charAt(i)){
                        x++;
                    }
                }
                min = Math.min(x,min);
                if (x==1){
                    strings.remove(next);
                    start = next;
                    break;
                }
            }
            if (start.equals(end)){
                return bank.length-strings.size();
            }else if (min>1){
                return -1;
            }
        }
        return start.equals(end) ?bank.length:-1;
    }
}
