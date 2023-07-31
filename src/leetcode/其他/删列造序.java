package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/5/12 21:42
 * @role:
 */
public class 删列造序 {
    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] strs) {
        int y = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            int x = 0;
            for (String str : strs) {
                if (x <= str.charAt(i)) {
                    x = str.charAt(i);
                } else {
                    y++;
                    break;
                }
            }
        }
        return y;
    }
}
