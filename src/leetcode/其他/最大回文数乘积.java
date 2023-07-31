package leetcode.其他;

/**
 * @Author: Ljx
 * @Date: 2022/4/16 16:43
 * @role: https://leetcode-cn.com/problems/largest-palindrome-product/
 */

public class 最大回文数乘积 {

    public static void main(String[] args) {
        System.out.println(largestPalindrome(3));
    }
    public static int largestPalindrome(int n) {
        long x = (long) (Math.pow(10,n)-1);
        long y = (long) (Math.pow(10,n-1));
        long max = 0;
        for (long i = x; i >= y; i--) {
            for (long l = x; l >= y; l--) {
                if (x(i*l)){
                    max = Math.max(max,i*l);
                }
            }
        }
        return (int) (max%1337);
    }

    public static boolean x(long lo){
        String s = String.valueOf(lo);
        int left = 0;
        int right = s.length()-1;
        while (left<=right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
