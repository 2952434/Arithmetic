package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/4/24 11:10
 * @role: https://leetcode-cn.com/problems/binary-gap/
 */
public class 二进制间距 {
    public static void main(String[] args) {
        System.out.println(binaryGap(6));
    }

    public static int binaryGap(int n) {
        String s = Integer.toString(n, 2);
        if (s.indexOf("1")==s.lastIndexOf("1")){
            return 0;
        }
        int x = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1'){
                max = Math.max(max,i-x);
                x = i;
            }
        }
        return max;
    }

}
