package leetcode.其他;

import java.util.*;

/**
 * @Author: Ljx
 * @Date: 2022/5/3 23:31
 * @role:
 */
public class 重新排列日志文件 {
    public static void main(String[] args) {

        reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
    }

    public static String[] reorderLogFiles(String[] logs) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (String log : logs) {
            int i = log.indexOf(" ");
            int i1 = log.charAt(i + 1) - '0';
            if (i1>=0&&i1<10){
                list1.add(log);
            }else {
                list2.add(log);
            }
        }
        list2.sort((o1, o2) -> {
            int i = o1.indexOf(" ");
            int i1 = o2.indexOf(" ");
            int i2 = o1.substring(i + 1).compareTo(o2.substring(i1 + 1));
            return i2 ==0?o1.compareTo(o2): i2;
        });
        String[] arr = new String[logs.length];
        for (int i = 0; i < list2.size(); i++) {
            arr[i] = list2.get(i);
        }
        for (int i = 0; i < list1.size(); i++) {
            arr[i+list2.size()] = list1.get(i);
        }
        return arr;
    }
}
