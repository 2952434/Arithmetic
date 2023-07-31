package leetcode.其他;

import java.util.Arrays;

/**
 * @Author: Ljx
 * @Date: 2022/5/9 12:41
 * @role:
 */
public class 增减字符串匹配 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("DDIIDIDIID")));
    }
    public static int[] diStringMatch(String s) {
        int[] arr = new int[s.length()+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='D'){
                int x = i;
                while (i < s.length()&&s.charAt(i)=='D'){
                    i++;
                }
                sort(arr,x,i);
            }
        }
        return arr;
    }

    public static void sort(int[] arr,int begin,int end){
        while (begin<end){
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }

}
