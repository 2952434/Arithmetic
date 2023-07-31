package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2022/8/1 9:53
 * @role:
 */
public class 生成每种字符都是奇数个的字符串 {
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n%2==1){
            for (int i = 0; i < n; i++) {
                stringBuilder.append("a");
            }
        }else {
            for (int i = 0; i < n-1; i++) {
                stringBuilder.append("a");
            }
            stringBuilder.append("b");
        }
        return stringBuilder.toString();
    }
}
