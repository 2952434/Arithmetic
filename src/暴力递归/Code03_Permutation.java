package 暴力递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 9:40
 * @role: 打印全排列并去重
 */
public class Code03_Permutation {

    public List<String> Permutation (String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs,0,res);
        return res;
    }

    private void process(char[] str, int i, List<String> res) {
        if (i == str.length){
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
