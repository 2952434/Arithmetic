package leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ljx
 * @Date: 2022/7/3 9:26
 * @role:
 */
public class 下一个更大元素III {

    public static void main(String[] args) {
        nextGreaterElement(12);
    }

    public static int nextGreaterElement(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        if (s.length()==1){
            return -1;
        }
        int x = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i-1)<s.charAt(i)){
                x = i-1;
                break;
            }
            if (i-1==0){
                return -1;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i)>s.charAt(x)){
                char c = s.charAt(i);
                s.replace(i,i+1, String.valueOf(s.charAt(x)));
                s.replace(x,x+1,String.valueOf(c));
                break;
            }
        }
        StringBuilder s1 = new StringBuilder(s.substring(x + 1));
        s.delete(x+1,s.length());
        s1.reverse();
        s.append(s1);
        return Long.parseLong(String.valueOf(s)) > Integer.MAX_VALUE?-1: (int) Long.parseLong(String.valueOf(s));
    }

    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
