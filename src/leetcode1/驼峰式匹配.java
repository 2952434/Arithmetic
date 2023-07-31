package leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2023/4/14 9:19
 * @role:
 */
public class 驼峰式匹配 {

    public static void main(String[] args) {

        camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FB");
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        c:
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            char[] queryCharArray = query.toCharArray();
            char[] patternCharArray = pattern.toCharArray();
            int pIndex = 0;
            for (int j = 0; j < queryCharArray.length; j++) {
                if (queryCharArray[j] == patternCharArray[pIndex]) {
                    pIndex++;
                    if (pIndex == patternCharArray.length) {
                        j++;
                        while (j < queryCharArray.length) {
                            if (queryCharArray[j] - 'a' < 0) {
                                list.add(false);
                                continue c;
                            }
                            j++;
                        }
                    }
                } else {
                    if (queryCharArray[j] - 'a' < 0) {
                        list.add(false);
                        continue c;
                    }
                }
            }
            if (pIndex!=patternCharArray.length){
                list.add(false);
            }else {
                list.add(true);
            }

        }
        return list;
    }
}
