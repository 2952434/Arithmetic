package 暴力递归;

/**
 * @Author: Ljx
 * @Date: 2023/4/18 10:17
 * @role:
 */
public class Code06_ConvertToLetterString {


    public int number(String str) {
        char[] chars = str.toCharArray();
        return process(chars,0);
    }

    private int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == 0) {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str,i + 1);
            if (i + 1 < str.length) {
                res += process(str,i+2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str,i+1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str,i+2);
            }
            return res;
        }
        return process(str,i+1);
    }

}
